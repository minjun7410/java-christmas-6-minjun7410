package christmas.constants;

public enum ErrorMessage {
    INVALID_DAY_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_DAY_INPUT("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU_NAME("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_NUMBER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_INPUT("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NO_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATED_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_DRINK("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEED_MENU_COUNT("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
