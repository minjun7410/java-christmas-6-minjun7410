package christmas.event.discount;

import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.discount.WeekDayDiscountEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WeekDayDiscountEventTest {
    @DisplayName("평일 일 때 평일 이벤트 적용 가능 여부 테스트")
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(3);
        WeekDayDiscountEvent weekDayEvent = new WeekDayDiscountEvent(day, null);
        assertThat(weekDayEvent.isDiscountable()).isTrue();
    }

    @DisplayName("주말 일 때 평일 이벤트 적용 불가능 여부 테스트")
    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(2);
        WeekDayDiscountEvent weekDayEvent = new WeekDayDiscountEvent(day, null);
        assertThat(weekDayEvent.isDiscountable()).isFalse();
    }

    @DisplayName("평일 일 때 평일 이벤트 할인 금액 계산이 올바른 지 테스트")
    @Test
    void 할인_금액_계산_기능_테스트() {
        Day day = new Day(3);
        Map<String, Integer> orderSheet = new HashMap<>();
        orderSheet.put("초코케이크", 1);
        orderSheet.put("아이스크림", 1);
        WeekDayDiscountEvent weekDayEvent = new WeekDayDiscountEvent(day, new OrderSheet(orderSheet));
        assertThat(weekDayEvent.getDiscountedAmount()).isEqualTo(2023 * 2);
    }
}
