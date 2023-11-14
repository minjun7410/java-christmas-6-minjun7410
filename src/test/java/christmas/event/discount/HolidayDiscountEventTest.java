package christmas.event.discount;

import christmas.domain.day.Day;
import christmas.domain.event.discount.HolidayDiscountEvent;
import christmas.domain.order.OrderSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HolidayDiscountEventTest {
    @DisplayName("주말 혜택 적용 가능 테스트")
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(1);
        HolidayDiscountEvent holidayEvent = new HolidayDiscountEvent(day, null);
        assertThat(holidayEvent.isDiscountable()).isTrue();
    }

    @DisplayName("주말 혜택 적용 불가능 테스트")
    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(3);
        HolidayDiscountEvent holidayEvent = new HolidayDiscountEvent(day, null);
        assertThat(holidayEvent.isDiscountable()).isFalse();
    }

    @DisplayName("주말 혜택 할인 금액 계산이 올바른 지 테스트")
    @Test
    void 할인_금액_계산_기능_테스트() {
        Day day = new Day(1);
        Map<String, Integer> orderSheet = new HashMap<>();
        orderSheet.put("바비큐립", 1);
        orderSheet.put("티본스테이크", 1);
        HolidayDiscountEvent holidayEvent = new HolidayDiscountEvent(day, new OrderSheet(orderSheet));
        assertThat(holidayEvent.getDiscountedAmount()).isEqualTo(2023 * 2);
    }
}
