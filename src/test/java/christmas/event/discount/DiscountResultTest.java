package christmas.event.discount;

import christmas.domain.Day;
import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import christmas.domain.event.discount.ChristmasDiscountEvent;
import christmas.domain.event.discount.DiscountEvent;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.HolidayDiscountEvent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountResultTest {
    @Test
    void 총_할인_금액_계산_기능_테스트() {
        Day day = new Day(1);
        Map<String, Integer> orders = new HashMap<>();
        orders.put("바비큐립", 1);
        orders.put("티본스테이크", 1);
        OrderSheet orderSheet = new OrderSheet(orders);
        List<DiscountEvent> result = new ArrayList<>();
        result.add(new ChristmasDiscountEvent(day));
        result.add(new HolidayDiscountEvent(day, orderSheet));
        DiscountResult discountResult = new DiscountResult(result);
        assertThat(discountResult.getTotalDiscountAmount()).isEqualTo(1000 + 2023*2);
    }
}
