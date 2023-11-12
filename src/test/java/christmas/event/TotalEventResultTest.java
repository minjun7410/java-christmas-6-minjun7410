package christmas.event;

import christmas.domain.Day;
import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import christmas.domain.Price;
import christmas.domain.event.TotalEventResult;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.presentation.PresentationEventManager;
import christmas.domain.event.presentation.PresentationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalEventResultTest {
    private PresentationResult presentationResult;
    private DiscountResult discountResult;
    @BeforeEach
    void beforeEach() {
        Day day = new Day(20);
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        presentationResult = PresentationEventManager.getPresentationResult(orderSheet);
        discountResult = DiscountEventManager.getDiscountResult(day,orderSheet);
    }

    @Test
    void 총_혜택금액_계산_기능_테스트() {
        TotalEventResult totalEventResult = new TotalEventResult(discountResult, presentationResult);
        Price price = totalEventResult.getDiscountPrice();
        Price priceAnswer = new Price(presentationResult.getTotalPresentationPrice() + discountResult.getTotalDiscountAmount());
        assertThat(price.toString()).isEqualTo(priceAnswer.toString());
    }
}
