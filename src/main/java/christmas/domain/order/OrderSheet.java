package christmas.domain.order;

import christmas.constants.ErrorMessage;
import christmas.domain.Price;
import christmas.dto.MenuDTO;
import christmas.dto.PriceDTO;

import java.util.*;

public class OrderSheet {
    private static final int TOTAL_COUNT_LIMIT = 20;

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
        return totalPrice;
    }

    private void countMenu(Map<String, Integer> menus) {
        for (String menuName : menus.keySet()) {
            Menu menu = Menu.getMenuByName(menuName);
            orderSheet.put(menu, menus.get(menuName));
        }
    }

    public Price getTotalPrice() {
        return new Price(totalPrice);
    }

    public List<MenuDTO> getOrderSheet() {
        return orderSheet.keySet().stream()
                .map(menu -> new MenuDTO(menu.getName(), orderSheet.get(menu)))
                .toList();
    }

    public boolean isMoreThanTotal(int amount) {
        return totalPrice >= amount;
    }

    private void validateExceedMenuCount(Map<String, Integer> menus) {
        int totalMenuCount = menus.values().stream()
                .reduce(0, Integer::sum);
        if (totalMenuCount <= TOTAL_COUNT_LIMIT) return;
        throw new IllegalArgumentException(ErrorMessage.EXCEED_MENU_COUNT.getErrorMessage());
    }

    private void validateOnlyDrink() {
        int drinkCount = (int) orderSheet.keySet().stream()
                .filter(menu -> menu.compareType(MenuType.DRINK))
                .count();
        if (drinkCount == orderSheet.size()) throw new IllegalArgumentException(ErrorMessage.ONLY_DRINK.getErrorMessage());
    }
}
