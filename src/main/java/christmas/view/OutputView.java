package christmas.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] %s\n";
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    private static final String PREVIEW_START_MESSAGE = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";

    public void printStart() {
        System.out.print(START_MESSAGE);
    }
    public void printMenu() {
        System.out.println("<주문 메뉴>");
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE, message);
    }

    public void printPreviewStart() {
        System.out.println();
    }
}
