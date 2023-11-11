package christmas;

import christmas.domain.OrderSheet;
import christmas.domain.PresentationEvent;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentationDiscountEventTest {
    @Test
    void 총_주문금액_12만원_이상_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 3);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        PresentationEvent presentationEvent = new PresentationEvent(orderSheet);
        assertThat(presentationEvent.isDiscountable()).isTrue();
    }

    @Test
    void 총_주문금액_12만원_이하_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 1);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        PresentationEvent presentationEvent = new PresentationEvent(orderSheet);
        assertThat(presentationEvent.isDiscountable()).isFalse();
    }
}
