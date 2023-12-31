package christmas.event.present;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.present.PresentEventManager;
import christmas.dto.PresentResultDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentEventManagerTest {
    @DisplayName("증정 이벤트 적용 가능할 때 증정품이 샴페인 1개인 지 테스트")
    @Test
    void 샴페인_증정_이벤트_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        List<PresentResultDTO> presents = PresentEventManager.getPresentResult(orderSheet).getPresents();
        assertThat(presents.get(0).getCount()).isEqualTo(1);
    }

    @DisplayName("증정 이벤트 적용 불가능할 때 증정품이 없는 지 테스트")
    @Test
    void 샴페인_증정_이벤트_미증정_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 1);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        List<PresentResultDTO> presents = PresentEventManager.getPresentResult(orderSheet).getPresents();
        assertThat(presents.size()).isEqualTo(0);
    }
}
