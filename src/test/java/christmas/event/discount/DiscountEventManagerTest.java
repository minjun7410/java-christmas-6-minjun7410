package christmas.event.discount;

import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;
import christmas.domain.Price;
import christmas.domain.event.discount.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountEventManagerTest {
    @Test
    void 할인_적용_가능_이벤트_테스트_크리스마스_주말() {
        Day day = new Day(1);
        Map<String, Integer> orders = new HashMap<>();
        orders.put("바비큐립", 1);
        orders.put("티본스테이크", 1);
        OrderSheet orderSheet = new OrderSheet(orders);

        Map<DiscountEvent, Price> discountEventList = DiscountEventManager.getDiscountResult(day, orderSheet).getDiscountEvents();
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(ChristmasDiscountEvent.class);
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(HolidayDiscountEvent.class);
        });
    }

    @Test
    void 할인_적용_가능_이벤트_평일_별() {
        Day day = new Day(31);
        Map<String, Integer> orders = new HashMap<>();
        orders.put("바비큐립", 1);
        orders.put("티본스테이크", 1);
        OrderSheet orderSheet = new OrderSheet(orders);
        Map<DiscountEvent, Price> discountEventList = DiscountEventManager.getDiscountResult(day, orderSheet).getDiscountEvents();
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(WeekDayDiscountEvent.class);
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(StarDiscountEvent.class);
        });
    }
}
