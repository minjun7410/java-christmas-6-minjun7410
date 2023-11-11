package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String WRONG_DAY_TEXT = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (input.matches("\\d")) return;
        throw new IllegalArgumentException(WRONG_DAY_TEXT);
    }
}