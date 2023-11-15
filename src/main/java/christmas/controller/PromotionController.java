package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;
import christmas.domain.Price;
import christmas.domain.event.TotalEventResult;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.present.PresentEventManager;
import christmas.domain.event.present.PresentResult;
import christmas.dto.PriceDTO;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        Day orderDay = getOrderDay();
        OrderSheet orderSheet = getOrderSheet();
        printPreview(orderDay, orderSheet);
    }

    private Day getOrderDay() {
        boolean isInValidInput = true;
        Day orderDay = null;
        while(isInValidInput) {
            try {
                int dayNumber = inputView.readDate();
                orderDay = new Day(dayNumber);
                isInValidInput = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return orderDay;
    }

    private OrderSheet getOrderSheet() {
        boolean isInValidInput = true;
        OrderSheet orderSheet = null;
        while(isInValidInput) {
            try {
                Map<String, Integer> orderMenus = inputView.readMenu();
                orderSheet = new OrderSheet(orderMenus);
                isInValidInput = false;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
        return orderSheet;
    }

    private void printPreview(Day orderDay, OrderSheet orderSheet) {
        printBeforeEvent(orderSheet);
        printAfterEvent(orderDay, orderSheet);
    }

    private void printBeforeEvent(OrderSheet orderSheet) {
        outputView.printPreviewStart();
        outputView.printOrderSheet(orderSheet.getOrderSheet());
        outputView.printTotalPriceBeforeDiscount(PriceDTO.from(orderSheet.getTotalPrice()));
    }

    private void printAfterEvent(Day orderDay, OrderSheet orderSheet) {
        DiscountResult discountResult = DiscountEventManager.getDiscountResult(orderDay, orderSheet);
        PresentResult presentResult = PresentEventManager.getPresentResult(orderSheet);
        outputView.printPresents(presentResult.getPresents());
        outputView.printEvents(discountResult.getDiscountResults(), PriceDTO.from(presentResult.getTotalPresentPrice()));

        TotalEventResult totalEventResult = new TotalEventResult(discountResult, presentResult);
        outputView.printTotalDiscountPrice(totalEventResult.getDiscountPrice());
        outputView.printTotalDiscountedPrice(totalEventResult.getDiscountedPrice(orderSheet.getTotalPrice()));
        Badge badge = totalEventResult.getBadge();
        outputView.printBadge(badge);
    }
}
