package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputView {
    private static final String WRONG_DAY_TEXT = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String WRONG_MENU_NUMBER_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String WRONG_TYPE_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String NO_MENU_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String DUPLICATE_MENU_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateIsNumber(input, WRONG_DAY_TEXT);
        return Integer.parseInt(input);
    }

    public Map<String, Integer> readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        return getMenus(input);
    }

    private Map<String, Integer> getMenus(String input) {
        Map<String, Integer> menus = new HashMap<>();
        String[] inputs = splitInput(input);
        for (String menu : inputs) {
            String[] splitMenu = menu.trim().split("-");
            validateInputFormat(splitMenu);
            validateIsNumber(splitMenu[1], WRONG_MENU_NUMBER_TEXT);
            validateDuplicatedMenu(menus.keySet(), splitMenu[0]);
            menus.put(splitMenu[0], Integer.parseInt(splitMenu[1]));
        }
        return menus;
    }

    private String[] splitInput(String input) {
        String[] inputs = input.split(",");
        validateNoMenu(inputs);
        return inputs;
    }

    private void validateIsNumber(String input, String errorMessage) {
        if (input.matches("\\d+")) return;
        throw new IllegalArgumentException(errorMessage);
    }

    private void validateInputFormat(String[] inputs) {
        if (inputs.length == 2) return;
        throw new IllegalArgumentException(WRONG_TYPE_TEXT);
    }

    private void validateNoMenu(String[] inputs) {
        if (inputs.length == 0) throw new IllegalArgumentException(NO_MENU_TEXT);
    }

    private void validateDuplicatedMenu(Set<String> menuNames, String menuName) {
        if (menuNames.contains(menuName)) throw new IllegalArgumentException(DUPLICATE_MENU_TEXT);
    }
}