package christmas;

import christmas.domain.Day;
import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import christmas.domain.WeekDayEvent;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WeekDayEventTest {
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(3);
        OrderSheet orderSheet = null;
        WeekDayEvent weekDayEvent = new WeekDayEvent(day, orderSheet);
        assertThat(weekDayEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(2);
        OrderSheet orderSheet = null;
        WeekDayEvent weekDayEvent = new WeekDayEvent(day, orderSheet);
        assertThat(weekDayEvent.isDiscountable()).isFalse();
    }

    @Test
    void 할인_금액_계산_기능_테스트() {
        Day day = new Day(3);
        Map<String, Integer> orderSheet = new HashMap<>();
        orderSheet.put("초코케이크", 1);
        orderSheet.put("아이스크림", 1);
        WeekDayEvent weekDayEvent = new WeekDayEvent(day, new OrderSheet(orderSheet));
        assertThat(weekDayEvent.getDiscountedAmount()).isEqualTo(2023 * 2);
    }
}
