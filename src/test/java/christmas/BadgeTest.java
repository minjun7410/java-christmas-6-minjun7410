package christmas;

import christmas.domain.Badge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BadgeTest {
    @Test
    void 총_혜택_금액_테스트_별() {
        Badge badge = Badge.getBadgeByDiscountedAmount(5001);
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @Test
    void 총_혜택_금액_테스트_트리() {
        Badge badge = Badge.getBadgeByDiscountedAmount(12000);
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @Test
    void 총_혜택_금액_테스트_산타() {
        Badge badge = Badge.getBadgeByDiscountedAmount(21000);
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @Test
    void 총_혜택_금액_테스트_없음() {
        Badge badge = Badge.getBadgeByDiscountedAmount(0);
        assertThat(badge).isEqualTo(Badge.NONE);
    }
}
