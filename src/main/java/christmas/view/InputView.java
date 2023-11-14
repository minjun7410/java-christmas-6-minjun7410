package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.ErrorMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateIsNumber(input, ErrorMessage.INVALID_DAY_INPUT.getErrorMessage());
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
            validateIsNumber(splitMenu[1], ErrorMessage.INVALID_MENU_NUMBER.getErrorMessage());
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
        throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_INPUT.getErrorMessage());
    }

    private void validateNoMenu(String[] inputs) {
        if (inputs.length == 0) throw new IllegalArgumentException(ErrorMessage.NO_MENU.getErrorMessage());
    }

    private void validateDuplicatedMenu(Set<String> menuNames, String menuName) {
        if (menuNames.contains(menuName)) throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MENU.getErrorMessage());
    }
}