package christmas.order;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;
import christmas.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OrderSheetTest {
    @DisplayName("바비큐립 2개, 아이스크림 1개의 총 주문 금액 계산 테스트")
    @Test
    void 총_주문_금액_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 2);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);

        int correctAnswer = Menu.BBQ_LIP.getPrice() * 2 + Menu.ICECREAM.getPrice();
        assertThat(orderSheet.getTotalPrice().toString()).isEqualTo(new Price(correctAnswer).toString());
    }

    @DisplayName("제한 주문 갯수 20을 초과했을 때 예외처리 테스트")
    @Test
    void 총_주문_갯수_초과_예외처리_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 21);
        assertThatThrownBy(() -> new OrderSheet(menuCounts)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문서에 음료수 타입만 있을 때 예외처리 테스트")
    @Test
    void 메뉴_음료만_예외처리_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("제로콜라", 1);
        menuCounts.put("레드와인", 1);
        assertThatThrownBy(() -> new OrderSheet(menuCounts)).isInstanceOf(IllegalArgumentException.class);
    }
}
