package christmas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayTest {
    @Test
    void 주문_날짜_범위_안_테스트() {
        DayTest date = new DayTest(15);
        assertThat(date.isInBetween(1, 25)).isTrue();
    }

    @Test
    void 주문_날짜_범위_밖_테스트() {
        DayTest date = new DayTest(30);
        assertThat(date.isInBetween(1, 25)).isFalse();
    }
}
