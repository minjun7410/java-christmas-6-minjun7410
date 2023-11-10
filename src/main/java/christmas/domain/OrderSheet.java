package christmas.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderSheet {
    private Map<Menu, Integer> orderSheet;

    public OrderSheet(Map<String, Integer> menus) {
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
}
