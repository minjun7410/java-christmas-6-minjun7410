package christmas.event.present;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.present.PresentEventManager;
import christmas.domain.event.present.PresentResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
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
        Map<Menu, Integer> presents = PresentEventManager.getPresentResult(orderSheet).getPresents();
        presentResult = new PresentResult(presents);
    }

    @Test
    void 총_증정품_금액_테스트() {
        assertThat(presentResult.getTotalPresentPrice()).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @Test
    void 총_증정품_종류_테스트() {
        assertThat(presentResult.getPresents().get(Menu.CHAMPAGNE)).isEqualTo(1);
    }
}
