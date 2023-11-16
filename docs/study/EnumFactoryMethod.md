이번 주차 미션은 꽤나 어렵지만 그 중에서도 어려웠던게 여러 개의 이벤트를 다루는 것이었다. 기능에 대해 부가적으로 설명하면 주문을 했을 때 주문에 대해

1. 어떤 이벤트가 적용이 가능한 지 전부 확인하고
2. 할인을 적용해야한다.

이벤트가 매번 고정적인 갯수로 제공된다고 가정한다면 아래 코드처럼 생성자를 클라이언트에 둠으로써 쉽게 해결이 가능하지만
```java
discount() {
	ChristmasEvent cEvent = new ChristmasEvent();
	if (cEvent.isDiscountable()) {
		this.price -= cEvent.getDiscountPrice();
	}
	...
}
```
미션지에 나와있지 않은 추가적인 요구사항이 어떤게 있을까 생각하니까 "**이벤트가 추가될 수 있다**"는 가정을 추가하게 되었다. 그렇다면 위처럼 클라이언트에 `new` 생성자를 두는 것은 이벤트의 추가, 또는 삭제를 했을 때 클라이언트는 "이벤트 변경"에 대해 자유롭지 못하다는 뜻이다.

제한적인 이벤트의 갯수지만 충분히 추가, 삭제될 수 있는 문제. 이전에 상수들을 관리하는 Enum이 문득 생각났다. Enum을 통해서 이벤트를 추가하고 조건에 맞는 이벤트를 리턴하면 어떨까 생각하다 Enum으로 객체 생성에 대한 내용을 인터넷에 서칭을 해보았다.

# Enum Factory Method
객체 생성을 팩토리 클래스로 캡슐화 처리하는 팩토리 패턴과 같은 목적을 가지고 있다.
팩토리 패턴대로 팩토리 클래스로 분리하게 되면 얻는 이점은 결합도가 낮아지고 유지보수하기 좋아지는 이점이 있다.
하지만 팩토리 패턴은 구현체가 늘어날 수록 늘어난 숫자만큼 팩토리 클래스가 증가하여 팩토리 클래스 1 + 구현체 1, 총 2개씩 늘어나므로 클래스 수가 굉장히 많아진다는 단점이 있다. 게다가 팩토리 클래스는 객체를 생성할 때마다 인스턴스화 되므로 메모리를 많이 잡아먹는다는 단점 때문에 보통 싱글톤과 함께 사용한다.

Enum Factory Method는 enum에서 팩토리 메서드를 관리하므로 팩토리 클래스가 증가할 걱정이 없다. 그리고 기본적으로 각각 상수들은 싱글톤 클래스기 때문에 인스턴스화 걱정이 없다.

## 적용
Enum으로 이벤트를 생성하는 코드를 집어넣는다 라는 생각으로 코딩을 해보았다.
Enum으로 이벤트들을 리턴하기 전에 구체적인 이벤트들을 하나의 이벤트로 추상화해야했다.
```java
public interface DiscountEvent {  
    public boolean isDiscountable();  
    public int getDiscountedAmount();  
}
```
할인 이벤트는 할인 적용 가능한 지 확인할 수 있어야하고 할인된 금액을 리턴할 수 있어야한다.
```java
public class ChristmasDiscountEvent implements DiscountEvent {
	public ChristmasDiscountEvent(Day presentDay) {  
	    this.presentDay = presentDay;  
	    this.startDay = new Day(START_DAY);  
    }  
  
@Override  
public boolean isDiscountable() {  
    return presentDay.isInBetween(START_DAY, END_DAY); 
}  
  
@Override  
public int getDiscountedAmount() {  
    int dayDifference = presentDay.getDifference(startDay);  
    return BASE_AMOUNT + (UNIT_AMOUNT * dayDifference);  
}
```
그리고 인터페이스를 구현한 `ChristmasDiscountEvent`이다. 이 객체 만의 이벤트 적용 방식, 할인 적용 방식을 구현했다.

그리고 Enum 클래스 `DiscountEventManager`.
```java
public enum DiscountEventManager {  
	CHRISTMAS {  
	    public DiscountEvent create(Day day, OrderSheet orderSheet) {  
	        return new ChristmasDiscountEvent(day);  
	    }  
	},  
	HOLIDAY {  
	    public DiscountEvent create(Day day, OrderSheet orderSheet) {  
	        return new HolidayDiscountEvent(day, orderSheet);  
	    }  
	},
	    
	abstract protected DiscountEvent create(Day day, OrderSheet orderSheet);  
	  
	public static DiscountResult getDiscountResult(Day day, OrderSheet orderSheet) {  
	    if (orderSheet.isMoreThanTotal(10000)) {  
	        List<DiscountEvent> discountEvents = Arrays.stream(values())  
	                .map(event -> event.create(day, orderSheet))  
	                .filter(DiscountEvent::isDiscountable)  
	                .toList();  
	        return new DiscountResult(discountEvents);  
	    }  
	    return new DiscountResult(new ArrayList<>());  
	}
```
`DiscountEventManager.getDiscountResult`는 클라이언트로부터 `Day`와 `OrderSheet`을 받아서 이벤트 객체를 생성한 뒤 적용 가능한 이벤트만 남겨 리턴한다. (리턴된 이벤트는 각자 할인 가격을 계산하는 역할을 한다.)

각 이벤트의 구현된 메서드는 팩토리 메서드에서 구현 팩토리에 해당한다고 보면 된다.

적용한 후 아무리 이벤트가 추가, 삭제된다 하더라도 클라이언트는 이 변경에 대해서 몰라도 되며 결과적으로 변경에 자유로워진다.

# Reference
* https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-Enum-Factory-Method-%EB%B3%80%ED%98%95-%ED%8C%A8%ED%84%B4
