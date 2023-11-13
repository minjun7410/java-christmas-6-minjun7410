package christmas.event.presentation;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;
import christmas.domain.event.presentation.PresentationEventManager;
import christmas.domain.event.presentation.PresentationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PresentationResultTest {
    PresentationResult presentationResult;

    @BeforeEach
    void beforEach() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        Map<Menu, Integer> presentations = PresentationEventManager.getPresentationResult(orderSheet).getPresentations();
        presentationResult = new PresentationResult(presentations);
    }

    @Test
    void 총_증정품_금액_테스트() {
        assertThat(presentationResult.getTotalPresentationPrice()).isEqualTo(Menu.CHAMPAGNE.getPrice());
    }

    @Test
    void 총_증정품_종류_테스트() {
        assertThat(presentationResult.getPresentations().get(Menu.CHAMPAGNE)).isEqualTo(1);
    }
}
