package christmas;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderSheetTest {
    @Test
    void 총_주문_금액_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 2);
        menuCounts.put("아이스크림", 1);
        OrderSheet orderSheet = new OrderSheet(menuCounts);

        int answer = Menu.BBQ_LIP.getPrice() * 2 + Menu.ICECREAM.getPrice();
        assertThat(orderSheet.getTotalPrice()).isEqualTo(answer);
    }
}
