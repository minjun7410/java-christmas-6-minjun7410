package christmas.event;

import christmas.domain.Day;
import christmas.domain.OrderSheet;
import christmas.domain.event.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
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

        List<DiscountEvent> discountEventList = DiscountEventManager.getDiscountableEvents(day, orderSheet);
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.get(0)).isInstanceOf(ChristmasDiscountEvent.class);
            assertThat(discountEvents.get(1)).isInstanceOf(HolidayDiscountEvent.class);
        });
    }

    @Test
    void 할인_적용_가능_이벤트_평일_별() {
        Day day = new Day(31);
        Map<String, Integer> orders = new HashMap<>();
        orders.put("바비큐립", 1);
        orders.put("티본스테이크", 1);
        OrderSheet orderSheet = new OrderSheet(orders);
        List<DiscountEvent> discountEventList = DiscountEventManager.getDiscountableEvents(day, orderSheet);
        assertThat(discountEventList).satisfies(discountEvents -> {
            assertThat(discountEvents.get(0)).isInstanceOf(WeekDayDiscountEvent.class);
            assertThat(discountEvents.get(1)).isInstanceOf(StarDiscountEvent.class);
        });
    }
}
