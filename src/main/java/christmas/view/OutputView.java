package christmas.view;

import christmas.domain.Menu;
import christmas.domain.Price;

import java.sql.SQLOutput;
import java.util.Map;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] %s\n";
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    private static final String PREVIEW_START_MESSAGE = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_SHEET_TOP_MESSAGE = "<주문 메뉴>\n";
    private static final String ORDER_SHEET_MESSAGE = "%s %d개\n";
    private static final String TOTAL_BEFORE_DISCOUNT_TOP_MESSAGE = "<할인 전 총주문 금액>\n";
    private static final String TOTAL_BEFORE_DISCOUNT_MESSAGE = "%s원\n";

    public void printStart() {
        System.out.print(START_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE, message);
    }

    public void printPreviewStart() {
        System.out.println(PREVIEW_START_MESSAGE);
    }

    public void printOrderSheet(Map<Menu, Integer> orderSheet) {
        System.out.print(ORDER_SHEET_TOP_MESSAGE);
        for (Menu menu : orderSheet.keySet()) {
            System.out.printf(ORDER_SHEET_MESSAGE, menu.getName(), orderSheet.get(menu));
        }
        System.out.println();
    }

    public void printTotalPriceBeforeDiscount(Price price) {
        System.out.print(TOTAL_BEFORE_DISCOUNT_TOP_MESSAGE);
        System.out.printf(TOTAL_BEFORE_DISCOUNT_MESSAGE, price);
        System.out.println();
    }
}
