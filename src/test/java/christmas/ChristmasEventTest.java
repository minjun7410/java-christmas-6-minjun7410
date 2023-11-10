package christmas;

import christmas.domain.Day;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasEventTest {
    @Test
    void 디데이_계산_기능_테스트() {
        Day day = new Day(21);
        ChristmasEvent christmasEvent = new ChristmasEvent(day);
        int discountedAmount = christmasEvent.getDiscountedAmount();
        assertThat(discountedAmount).isEqualTo(1000 + 20 * 100);
    }
}
