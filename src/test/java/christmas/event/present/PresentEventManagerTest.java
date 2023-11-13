package christmas.event.present;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.present.PresentEventManager;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentEventManagerTest {
    @Test
    void 샴페인_증정_이벤트_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        Map<Menu, Integer> presents = PresentEventManager.getPresentResult(orderSheet).getPresents();
        assertThat(presents.get(Menu.CHAMPAGNE)).isEqualTo(1);
    }

    @Test
    void 샴페인_증정_이벤트_미증정_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 1);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        Map<Menu, Integer> presents = PresentEventManager.getPresentResult(orderSheet).getPresents();
        assertThat(presents.size()).isEqualTo(0);
    }
}
