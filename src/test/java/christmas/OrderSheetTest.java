package christmas;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.internal.matchers.Or;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    void 총_주문_갯수_초과_예외처리_테스트() {
        Map<String, Integer> menuCounts = new HashMap<>();
        menuCounts.put("바비큐립", 21);
        assertThatThrownBy(() -> new OrderSheet(menuCounts)).isInstanceOf(IllegalArgumentException.class);
    }
}
