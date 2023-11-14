package christmas.event.discount;

import christmas.domain.day.Day;
import christmas.domain.event.discount.StarDiscountEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StarDiscountEventTest {
    @DisplayName("특별 혜택 적용 가능 테스트")
    @Test
    void 할인_적용_가능_테스트() {
        Day day = new Day(25);
        StarDiscountEvent starEvent = new StarDiscountEvent(day);
        assertThat(starEvent.isDiscountable()).isTrue();
    }

    @DisplayName("특별 혜택 적용 불가능 테스트")
    @Test
    void 할인_적용_불가능_테스트() {
        Day day = new Day(26);
        StarDiscountEvent starEvent = new StarDiscountEvent(day);
        assertThat(starEvent.isDiscountable()).isFalse();
    }

    @DisplayName("특별 혜택 할인 금액 계산이 올바른 지 테스트")
    @Test
    void 할인_금액_계산_테스트() {
        Day day = new Day(25);
        StarDiscountEvent starEvent = new StarDiscountEvent(day);
        assertThat(starEvent.getDiscountedAmount()).isEqualTo(1000);
    }
}
