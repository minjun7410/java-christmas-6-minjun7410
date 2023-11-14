package christmas.event.present;

import christmas.domain.order.OrderSheet;
import christmas.domain.event.present.ChampagnePresentEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChampagnePresentDiscountEventTest {
    @DisplayName("총 주문 금액이 12만원 이상일 때 샴페인 증정 이벤트 적용 가능한 지 테스트")
    @Test
    void 총_주문금액_12만원_이상_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 3);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        ChampagnePresentEvent champagnePresentEvent = new ChampagnePresentEvent(orderSheet);
        assertThat(champagnePresentEvent.isPresentable()).isTrue();
    }

    @DisplayName("총 주문 금액이 12만원 이하일 때 샴페인 증정 이벤트 적용 블가능한 지 테스트")
    @Test
    void 총_주문금액_12만원_이하_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 1);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        ChampagnePresentEvent champagnePresentEvent = new ChampagnePresentEvent(orderSheet);
        assertThat(champagnePresentEvent.isPresentable()).isFalse();
    }
}
