package christmas.day;

import christmas.domain.day.Day;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DayTest {
    @DisplayName("주문 날짜가 지정한 범위 안에 있는 지 테스트")
    @Test
    void 주문_날짜_범위_안_테스트() {
        Day day = new Day(15);
        assertThat(day.isInBetween(1, 25)).isTrue();
    }

    @DisplayName("주문 날짜가 지정한 범위 밖에 있는 지 테스트")
    @Test
    void 주문_날짜_범위_밖_테스트() {
        Day day = new Day(30);
        assertThat(day.isInBetween(1, 25)).isFalse();
    }

    @DisplayName("주문 날짜가 별 표시 날짜가 맞을 때 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 25})
    void 주문_날짜_별인_날짜_테스트(int input) {
        Day day = new Day(input);
        assertThat(day.isStarDay()).isTrue();
    }

    @DisplayName("주문 날짜가 별 표시 날짜가 아닐 때 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 22})
    void 주문_날짜_별_아닌_날짜_테스트(int input) {
        Day day = new Day(input);
        assertThat(day.isStarDay()).isFalse();
    }

    @DisplayName("주문 날짜가 유효한 범위가 아닐 때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 32})
    void 날짜_유효하지_않은_범위_테스트(int input) {
        assertThatThrownBy(() -> new Day(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날짜 차이 계산 테스트")
    @Test
    void 백원_추가될_날짜_계산_테스트() {
        Day startDay = new Day(1);
        Day presentDay = new Day(25);
        int dayDifferent = presentDay.getDifference(startDay);
        assertThat(dayDifferent).isEqualTo(24);
    }
}
