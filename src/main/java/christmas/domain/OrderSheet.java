package christmas.domain;

import java.util.*;

public class OrderSheet {
    private static final String EXCEED_MENU_COUNT_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ONLY_DRINK_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String TOO_LITTLE_PRICE_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private Map<Menu, Integer> orderSheet;
    private int totalPrice;

    public OrderSheet(Map<String, Integer> menus) {
        orderSheet = new HashMap<>();
        validateExceedMenuCount(menus);
        countMenu(menus);
        calculateTotalPrice();
        validateOnlyDrink();
    }

    public int getMenuCountByMenuType(MenuType menuType) {
        int menuCount = orderSheet.keySet().stream()
                .filter(menu -> menu.compareType(menuType))
                .map(menu -> orderSheet.get(menu))
                .reduce(0, Integer::sum);
        return menuCount;
    }

    public int calculateTotalPrice() {
        this.totalPrice = orderSheet.keySet().stream()
                .map(menu -> menu.getPrice() * orderSheet.get(menu))
                .reduce(0, Integer::sum);
        validateTotalPrice();
        return totalPrice;
    }

    private void countMenu(Map<String, Integer> menus) {
        for (String menuName : menus.keySet()) {
            Menu menu = Menu.getMenuByName(menuName);
            orderSheet.put(menu, menus.get(menuName));
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    private void validateExceedMenuCount(Map<String, Integer> menus) {
        int totalMenuCount = menus.values().stream()
                .reduce(0, Integer::sum);
        if (totalMenuCount <= 20) return;
        throw new IllegalArgumentException(EXCEED_MENU_COUNT_TEXT);
    }

    private void validateOnlyDrink() {
        int drinkCount = (int) orderSheet.keySet().stream()
                .filter(menu -> menu.compareType(MenuType.DRINK))
                .count();
        if (drinkCount == orderSheet.size()) throw new IllegalArgumentException(ONLY_DRINK_TEXT);
    }

    private void validateTotalPrice() {
        if (totalPrice >= 10000) return;
        throw new IllegalArgumentException(TOO_LITTLE_PRICE_TEXT);
    }
}
