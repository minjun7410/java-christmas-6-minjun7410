package christmas;

import christmas.domain.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BadgeTest {
    @DisplayName("총 혜택금액이 5000원 이상일 때 배지가 별인 지 테스트")
    @Test
    void 총_혜택_금액_테스트_별() {
        Badge badge = Badge.getBadgeByDiscountedAmount(5001);
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @DisplayName("총 혜택금액이 10000원 이상일 때 배지가 트리인 지 테스트")
    @Test
    void 총_혜택_금액_테스트_트리() {
        Badge badge = Badge.getBadgeByDiscountedAmount(12000);
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @DisplayName("총 혜택금액이 20000원 이상일 때 배지가 산타인 지 테스트")
    @Test
    void 총_혜택_금액_테스트_산타() {
        Badge badge = Badge.getBadgeByDiscountedAmount(21_000);
        assertThat(badge).isEqualTo(Badge.SANTA);
    }

    @DisplayName("아무 배지도 못 받을 경우 테스트")
    @Test
    void 총_혜택_금액_테스트_없음() {
        Badge badge = Badge.getBadgeByDiscountedAmount(0);
        assertThat(badge).isEqualTo(Badge.NONE);
    }
}
