package christmas.view;

import christmas.domain.Badge;
import christmas.domain.order.Menu;
import christmas.domain.Price;
import christmas.dto.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] %s\n";
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    private static final String PREVIEW_START_MESSAGE = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_SHEET_TOP_MESSAGE = "<주문 메뉴>\n";
    private static final String ORDER_SHEET_MESSAGE = "%s %d개\n";
    private static final String TOTAL_BEFORE_DISCOUNT_TOP_MESSAGE = "<할인 전 총주문 금액>\n";
    private static final String TOTAL_BEFORE_DISCOUNT_MESSAGE = "%s원\n";
    private static final String PRESENT_TOP_MESSAGE = "<증정 메뉴>\n";
    private static final String PRESENT_MESSAGE = "%s %d개\n";
    private static final String EVENTS_TOP_MESSAGE = "<혜택 내역>\n";
    private static final String EVENT_MESSAGE = "%s: -%s원\n";
    private static final String TOTAL_DISCOUNT_TOP_MESSAGE = "<총혜택 금액>\n";
    private static final String TOTAL_DISCOUNT_MESSAGE = "%s원\n";
    private static final String DISCOUNTED_PRICE_TOP_MESSAGE = "<할인 후 예상 결제 금액>\n";
    private static final String DISCOUNTED_PRICE_MESSAGE = "%s원\n";
    private static final String BADGE_TOP_MESSAGE = "<12월 이벤트 배지>\n";
    private static final String NOTHING = "없음\n";

    public void printStart() {
        System.out.print(START_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE, message);
    }

    public void printPreviewStart() {
        System.out.println(PREVIEW_START_MESSAGE);
    }

    public void printOrderSheet(List<MenuDTO> orderSheet) {
        System.out.print(ORDER_SHEET_TOP_MESSAGE);
        for (MenuDTO menu : orderSheet) {
            System.out.printf(ORDER_SHEET_MESSAGE, menu.getMenuName(), menu.getCount());
        }
        System.out.println();
    }

    public void printTotalPriceBeforeDiscount(PriceDTO price) {
        System.out.print(TOTAL_BEFORE_DISCOUNT_TOP_MESSAGE);
        System.out.printf(TOTAL_BEFORE_DISCOUNT_MESSAGE, price.getPrice());
        System.out.println();
    }

    public void printPresents(List<PresentResultDTO> presents) {
        System.out.print(PRESENT_TOP_MESSAGE);
        if (hasNothing(presents.size())) return;
        for (PresentResultDTO presentResult : presents) {
            System.out.printf(PRESENT_MESSAGE, presentResult.getPresentName(), presentResult.getCount());
        }
        System.out.println();
    }

    public void printEvents(List<DiscountResultDTO> discountEvents, PriceDTO presentationsPrice) {
        System.out.print(EVENTS_TOP_MESSAGE);
        if (hasNothing(discountEvents.size())) return;
        for (DiscountResultDTO event : discountEvents) {
            System.out.printf(EVENT_MESSAGE, event.getEventName(), event.getPrice());
        }
        System.out.printf(EVENT_MESSAGE, "증정 이벤트", presentationsPrice.getPrice());
        System.out.println();
    }

    public void printTotalDiscountPrice(PriceDTO price) {
        System.out.print(TOTAL_DISCOUNT_TOP_MESSAGE);
        System.out.printf(TOTAL_DISCOUNT_MESSAGE, price.getPrice());
        System.out.println();
    }

    public void printTotalDiscountedPrice(PriceDTO price) {
        System.out.print(DISCOUNTED_PRICE_TOP_MESSAGE);
        System.out.printf(DISCOUNTED_PRICE_MESSAGE, price.getPrice());
        System.out.println();
    }

    public void printBadge(BadgeDTO badge) {
        System.out.print(BADGE_TOP_MESSAGE);
        System.out.println(badge.getBadgeName());
    }

    private boolean hasNothing(int size) {
        if (size == 0) {
            System.out.println(NOTHING);
            return true;
        }
        return false;
    }
}
