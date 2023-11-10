package christmas;

import christmas.domain.Day;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DayTest {
    @Test
    void 주문_날짜_범위_안_테스트() {
        Day day = new Day(15);
        assertThat(day.isInBetween(1, 25)).isTrue();
    }

    @Test
    void 주문_날짜_범위_밖_테스트() {
        Day day = new Day(30);
        assertThat(day.isInBetween(1, 25)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 25})
    void 주문_날짜_별인_날짜_테스트(int input) {
        Day day = new Day(input);
        assertThat(day.isStarDay()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 22})
    void 주문_날짜_별_아닌_날짜_테스트(int input) {
        Day day = new Day(input);
        assertThat(day.isStarDay()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 32})
    void 날짜_유효하지_않은_범위_테스트(int input) {
        assertThatThrownBy(() -> new Day(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 백원_추가될_날짜_계산_테스트() {
        Day startDay = new Day(1);
        Day presentDay = new Day(25);
        int dayDifferent = presentDay.getDifference(startDay);
        assertThat(dayDifferent).isEqualTo(24);
    }
}
