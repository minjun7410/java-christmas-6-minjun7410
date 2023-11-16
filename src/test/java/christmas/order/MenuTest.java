package christmas.order;

import christmas.domain.order.Menu;
import christmas.domain.order.MenuType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuTest {
    @DisplayName("주문한 메뉴가 디저트 타입인 지 체크하는 기능 테스트")
    @Test
    void 주문한_메뉴_디저트_테스트() {
        Menu menu = Menu.ICECREAM;
        assertThat(menu.compareType(MenuType.DESERT)).isTrue();
    }

    @DisplayName("주문한 메뉴가 메인 타입인 지 체크하는 기능 테스트")
    @Test
    void 주문한_메뉴_메인메뉴_테스트() {
        Menu menu = Menu.BBQ_LIP;
        assertThat(menu.compareType(MenuType.MAIN)).isTrue();
    }

    @DisplayName("주문한 메뉴가 없을 경우 예외처리 테스트")
    @Test
    void 메뉴에_있는지_예외처리_테스트() {
        assertThatThrownBy(() -> Menu.getMenuByName("케잌")).isInstanceOf(IllegalArgumentException.class);
    }
}
