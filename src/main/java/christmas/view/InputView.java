package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputView {
    private static final String WRONG_DAY_TEXT = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String WRONG_TYPE_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String NO_MENU_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String DUPLICATE_MENU_TEXT = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (input.matches("\\d+")) return;
        throw new IllegalArgumentException(WRONG_DAY_TEXT);
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