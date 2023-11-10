package christmas;

import christmas.domain.Menu;
import christmas.domain.MenuType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuTest {
    @Test
    void 주문한_메뉴_디저트_테스트() {
        Menu menu = Menu.ICECREAM;
        assertThat(menu.compareType(MenuType.DESERT)).isTrue();
    }

    @Test
    void 주문한_메뉴_메인메뉴_테스트() {
        Menu menu = Menu.BBQ_LIP;
        assertThat(menu.compareType(MenuType.MAIN)).isTrue();
    }

    @Test
    void 메뉴에_있는지_예외처리_테스트() {
        assertThatThrownBy(() -> Menu.getMenuByName("케잌")).isInstanceOf(IllegalArgumentException.class);
    }
}
