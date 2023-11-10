package christmas;

import christmas.domain.Day;
import christmas.domain.HolidayEvent;
import christmas.domain.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HolidayEventTest {
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(1);
        Map<Menu, Integer> orderSheet = new HashMap<>();
        HolidayEvent holidayEvent = new HolidayEvent(day, orderSheet);
        assertThat(holidayEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(3);
        Map<Menu, Integer> orderSheet = new HashMap<>();
        HolidayEvent holidayEvent = new HolidayEvent(day, orderSheet);
        assertThat(holidayEvent.isDiscountable()).isFalse();
    }

    @Test
    void 할인_금액_계산_기능_테스트() {
        Day day = new Day(1);
        Map<Menu, Integer> orderSheet = new HashMap<>();
        orderSheet.put(Menu.BBQ_LIP, 1);
        orderSheet.put(Menu.T_BONE_STEAK, 1);
        HolidayEvent holidayEvent = new HolidayEvent(day, orderSheet);
        assertThat(holidayEvent.getDiscountedAmount()).isEqualTo(2023 * 2);
    }
}
