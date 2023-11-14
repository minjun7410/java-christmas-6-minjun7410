package christmas.event.discount;

import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;
import christmas.domain.Price;
import christmas.domain.event.discount.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
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

        Map<DiscountEvent, Price> discountEventList = DiscountEventManager.getDiscountResult(day, orderSheet).getDiscountEvents();
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(ChristmasDiscountEvent.class);
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(HolidayDiscountEvent.class);
        });
    }

    @DisplayName("할인 적용 가능한 이벤트가 평일, 별 이벤트일 때 테스트")
    @Test
    void 할인_적용_가능_이벤트_평일_별() {
        Day day = new Day(31);

        Map<DiscountEvent, Price> discountEventList = DiscountEventManager.getDiscountResult(day, orderSheet).getDiscountEvents();
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(WeekDayDiscountEvent.class);
            assertThat(discountEvents.keySet()).extracting("class").hasSameClassAs(StarDiscountEvent.class);
        });
    }
}
