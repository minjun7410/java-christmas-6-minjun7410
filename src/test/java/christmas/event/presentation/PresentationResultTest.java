package christmas.event.presentation;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import christmas.domain.event.presentation.PresentationEventManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentationResultTest {
    @BeforeEach
    void beforEach() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        List<Menu> presentations = PresentationEventManager.getPresentations(orderSheet);
        PresentationResult presentationResult = new PresentationResult(presentations);
    }

    @Test
    void 총_증정품_금액_테스트() {
        assertThat(presentationResult.getTotalPresentationPrice()).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @Test
    void 총_증정품_종류_테스트() {
        assertThat(presentationResult.getPresentations().get(0)).isEqualTo(Menu.CHAMPAGNE);
    }
}
