package christmas.day;

import christmas.domain.day.DayOfWeek;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayOfWeekTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 주말_요일_테스트(int input) {
        assertThat(DayOfWeek.isHoliday(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 13})
    void 평일_요일_테스트(int input) {
        assertThat(DayOfWeek.isHoliday(input)).isFalse();
    }
}
