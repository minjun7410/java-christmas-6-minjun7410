package christmas.event.presentation;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import christmas.domain.event.presentation.PresentationEventManager;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentationEventManagerTest {
    @Test
    void 샴페인_증정_이벤트_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        List<Menu> presentations = PresentationEventManager.getPresentations(orderSheet).getPresentations();
        assertThat(presentations.get(0)).isEqualTo(Menu.CHAMPAGNE);
    }

    @Test
    void 샴페인_증정_이벤트_미증정_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 1);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        List<Menu> presentations = PresentationEventManager.getPresentations(orderSheet).getPresentations();
        assertThat(presentations.size()).isEqualTo(0);
    }
}
