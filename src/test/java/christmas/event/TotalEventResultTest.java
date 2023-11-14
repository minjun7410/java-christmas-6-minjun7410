package christmas.event;

import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;
import christmas.domain.Price;
import christmas.domain.event.TotalEventResult;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.present.PresentEventManager;
import christmas.domain.event.present.PresentResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalEventResultTest {
    private PresentResult presentResult;
    private DiscountResult discountResult;

    @BeforeEach
    void beforeEach() {
        Day day = new Day(20);
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 5);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);
        presentResult = PresentEventManager.getPresentResult(orderSheet);
        discountResult = DiscountEventManager.getDiscountResult(day,orderSheet);
    }

    @DisplayName("총 혜택 금액을 계산이 올바른 지 테스트")
    @Test
    void 총_혜택금액_계산_기능_테스트() {
        TotalEventResult totalEventResult = new TotalEventResult(discountResult, presentResult);
        Price price = totalEventResult.getDiscountPrice();
        Price priceAnswer = new Price(presentResult.getTotalPresentPrice() + discountResult.getTotalDiscountAmount());
        assertThat(price.toString()).isEqualTo(priceAnswer.toString());
    }

    @Test
    void 예상_결제_금액_계산_테스트() {
        TotalEventResult totalEventResult = new TotalEventResult(discountResult, presentResult);
        Price price = totalEventResult.getDiscountedPrice(new Price(100_000));
        Price correctPrice = new Price(100_000 - discountResult.getTotalDiscountAmount());
        assertThat(price.toString()).isEqualTo(correctPrice.toString());
    }
}
