package christmas.event.discount;

import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.discount.*;
import christmas.dto.DiscountResultDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountEventManagerTest {
    private OrderSheet orderSheet;
    @BeforeEach
    void beforeEach() {
        Map<String, Integer> orders = new HashMap<>();
        orders.put("바비큐립", 1);
        orders.put("티본스테이크", 1);
        orderSheet = new OrderSheet(orders);
    }

    @DisplayName("할인 적용 가능한 이벤트가 크리스마스, 주말 이벤트일 때 테스트")
    @Test
    void 할인_적용_가능_이벤트_테스트_크리스마스_주말() {
        Day day = new Day(1);

        List<DiscountResultDTO> discountEventList = DiscountEventManager.getDiscountResult(day, orderSheet).getDiscountResults();
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.get(0).getEventName()).isEqualTo("크리스마스 디데이 할인");
            assertThat(discountEvents.get(1).getEventName()).isEqualTo("주말 할인");
        });
    }

    @DisplayName("할인 적용 가능한 이벤트가 평일, 별 이벤트일 때 테스트")
    @Test
    void 할인_적용_가능_이벤트_평일_별() {
        Day day = new Day(31);

        List<DiscountResultDTO> discountEventList = DiscountEventManager.getDiscountResult(day, orderSheet).getDiscountResults();
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.get(0).getEventName()).isEqualTo("평일 할인");
            assertThat(discountEvents.get(1).getEventName()).isEqualTo("특별 할인");
        });
    }
}
