package christmas.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] %s\n";
    public void printMenu() {
        System.out.println("<주문 메뉴>");
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE, message);
    }
}
