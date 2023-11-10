package christmas;

import christmas.domain.Day;
import christmas.domain.StarEvent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StarEventTest {
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(25);
        StarEvent starEvent = new StarEvent(day);
        assertThat(starEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(26);
        StarEvent starEvent = new StarEvent(day);
        assertThat(starEvent.isDiscountable()).isFalse();
    }
}
