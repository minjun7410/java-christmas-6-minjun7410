package christmas.event.present;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.present.PresentEventManager;
import christmas.domain.event.present.PresentResult;
import christmas.dto.PresentResultDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentResultTest {
    PresentResult presentResult;

    @BeforeEach
    void beforEach() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        presentResult = PresentEventManager.getPresentResult(orderSheet);
    }

    @DisplayName("증정 이벤트 적용 가능할 때 증정 혜택금이 샴페인 가격인 지 테스트")
    @Test
    void 총_증정품_금액_테스트() {
        assertThat(presentResult.getTotalPresentPrice()).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @DisplayName("증정 이벤트 적용 가능할 때 증정품 갯수가 1인 지 테스트")
    @Test
    void 총_증정품_종류_테스트() {
        assertThat(presentResult.getPresents().size()).isEqualTo(1);
    }
}
