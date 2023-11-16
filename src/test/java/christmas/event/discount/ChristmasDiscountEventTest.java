package christmas.event.discount;

import christmas.domain.event.discount.ChristmasDiscountEvent;
import christmas.domain.day.Day;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasDiscountEventTest {
    @DisplayName("디데이 할인 금액 계산이 옯바른 지 테스트")
    @Test
    void 디데이_계산_기능_테스트() {
        Day day = new Day(21);
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent(day);
        int discountedAmount = christmasEvent.getDiscountedAmount();
        assertThat(discountedAmount).isEqualTo(1_000 + 20 * 100);
    }

    @DisplayName("디데이 할인 적용 가능 테스트")
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(21);
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent(day);
        assertThat(christmasEvent.isDiscountable()).isTrue();
    }

    @DisplayName("디데이 할인 적용 불가능 테스트")
    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(31);
        ChristmasDiscountEvent christmasEvent = new ChristmasDiscountEvent(day);
        assertThat(christmasEvent.isDiscountable()).isFalse();
    }
}
