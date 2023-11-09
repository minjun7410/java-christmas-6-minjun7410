package christmas;

import christmas.domain.Day;
import org.junit.jupiter.api.Test;

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
}
