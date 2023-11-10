package christmas;

import christmas.domain.Day;
import christmas.domain.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WeekDayEventTest {
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(3);
        Map<Menu, Integer> orderSheet = new HashMap<>();
        orderSheet.put(Menu.BBQ_LIP, 1);
        WeekDayEvent weekDayEvent = new WeekDayEvent(day, orderSheet);
        assertThat(weekDayEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(2);
        Map<Menu, Integer> orderSheet = new HashMap<>();
        orderSheet.put(Menu.BBQ_LIP, 1);
        WeekDayEvent weekDayEvent = new WeekDayEvent(day, orderSheet);
        assertThat(weekDayEvent.isDiscountable()).isFalse();
    }
}
