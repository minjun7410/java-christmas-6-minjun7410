package christmas.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSheet {
    private static final String EXCEED_MENU_COUNT_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private Map<Menu, Integer> orderSheet;

    public OrderSheet(Map<String, Integer> menus) {
        validateExceedMenuCount(menus);
        orderSheet = new HashMap<>();
        countMenu(menus);
    }

    public int getMenuCountByMenuType(MenuType menuType) {
        int menuCount = orderSheet.keySet().stream()
                .filter(menu -> menu.compareType(menuType))
                .map(menu -> orderSheet.get(menu))
                .reduce(0, Integer::sum);
        return menuCount;
    }

    public int getTotalPrice() {
        int totalPrice = orderSheet.keySet().stream()
                .map(menu -> menu.getPrice() * orderSheet.get(menu))
                .reduce(0, Integer::sum);
        return totalPrice;
    }

    private void countMenu(Map<String, Integer> menus) {
        for (String menuName : menus.keySet()) {
            Menu menu = Menu.getMenuByName(menuName);
            orderSheet.put(menu, menus.get(menuName));
        }
    }

    private void validateExceedMenuCount(Map<String, Integer> menus) {
        int totalMenuCount = menus.values().stream()
                .reduce(0, Integer::sum);
        if (totalMenuCount <= 20) return;
        throw new IllegalArgumentException(EXCEED_MENU_COUNT_TEXT);
    }
}
