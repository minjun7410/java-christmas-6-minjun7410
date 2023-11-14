package christmas.day;

import christmas.domain.day.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayOfWeekTest {
    @DisplayName("주문 날짜가 주말일 경우 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 주말_요일_테스트(int input) {
        assertThat(DayOfWeek.isHoliday(input)).isTrue();
    }

    @DisplayName("주문 날짜가 평일일 경우 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 13})
    void 평일_요일_테스트(int input) {
        assertThat(DayOfWeek.isHoliday(input)).isFalse();
    }
}
