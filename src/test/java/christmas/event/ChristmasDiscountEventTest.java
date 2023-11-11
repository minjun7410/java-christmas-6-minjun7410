package christmas.event;

import christmas.domain.event.ChristmasDiscountEvent;
import christmas.domain.Day;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasDiscountEventTest {
    @Test
    void 디데이_계산_기능_테스트() {
        Day day = new Day(21);
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent(day);
        int discountedAmount = christmasEvent.getDiscountedAmount();
        assertThat(discountedAmount).isEqualTo(1000 + 20 * 100);
    }

    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(21);
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent(day);
        assertThat(christmasEvent.isDiscountable()).isTrue();
    }

    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(31);
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent(day);
        assertThat(christmasEvent.isDiscountable()).isFalse();
    }
}
