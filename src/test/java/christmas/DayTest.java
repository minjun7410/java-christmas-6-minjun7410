package christmas;

import christmas.domain.Day;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
