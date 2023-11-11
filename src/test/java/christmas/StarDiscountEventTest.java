package christmas;

import christmas.domain.Day;
import christmas.domain.event.StarDiscountEvent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StarDiscountEventTest {
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(25);
        StarDiscountEvent starEvent = new StarDiscountEvent(day);
        assertThat(starEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(26);
        StarDiscountEvent starEvent = new StarDiscountEvent(day);
        assertThat(starEvent.isDiscountable()).isFalse();
    }

    @Test
    void 할인_금액_계산_테스트() {
        Day day = new Day(25);
        StarDiscountEvent starEvent = new StarDiscountEvent(day);
        assertThat(starEvent.getDiscountedAmount()).isEqualTo(1000);
    }
}
