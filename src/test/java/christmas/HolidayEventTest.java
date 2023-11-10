package christmas;

import christmas.domain.Day;
import christmas.domain.HolidayEvent;
import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HolidayEventTest {
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(1);
        OrderSheet orderSheet = null;
        HolidayEvent holidayEvent = new HolidayEvent(day, orderSheet);
        assertThat(holidayEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(3);
        OrderSheet orderSheet = null;
        HolidayEvent holidayEvent = new HolidayEvent(day, orderSheet);
        assertThat(holidayEvent.isDiscountable()).isFalse();
    }

    @Test
    void 할인_금액_계산_기능_테스트() {
        Day day = new Day(1);
        Map<String, Integer> orderSheet = new HashMap<>();
        orderSheet.put("바비큐립", 1);
        orderSheet.put("티본스테이크", 1);
        HolidayEvent holidayEvent = new HolidayEvent(day, new OrderSheet(orderSheet));
        assertThat(holidayEvent.getDiscountedAmount()).isEqualTo(2023 * 2);
    }
}
