package christmas;

import christmas.domain.Day;
import christmas.domain.OrderSheet;
import christmas.domain.Price;
import christmas.domain.event.TotalEventResult;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.presentation.PresentationEventManager;
import christmas.domain.event.presentation.PresentationResult;
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
        while(true) {
            try {
                int dayNumber = inputView.readDate();
                Day orderDay = new Day(dayNumber);
                return orderDay;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private OrderSheet getOrderSheet() {
        while(true) {
            try {
                Map<String, Integer> orderMenus = inputView.readMenu();
                OrderSheet orderSheet = new OrderSheet(orderMenus);
                return orderSheet;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printPreview(Day orderDay, OrderSheet orderSheet) {
        printBeforeEvent(orderSheet);
        printAfterEvent(orderDay, orderSheet);
    }

    private void printBeforeEvent(OrderSheet orderSheet) {
        outputView.printPreviewStart();
        outputView.printOrderSheet(orderSheet.getOrderSheet());
        outputView.printTotalPriceBeforeDiscount(orderSheet.getTotalPrice());
    }

    private void printAfterEvent(Day orderDay, OrderSheet orderSheet) {
        DiscountResult discountResult = DiscountEventManager.getDiscountResult(orderDay, orderSheet);
        PresentationResult presentationResult = PresentationEventManager.getPresentationResult(orderSheet);
        outputView.printPresentations(presentationResult.getPresentations());
        outputView.printEvents(discountResult.getDiscountEvents(), new Price(presentationResult.getTotalPresentationPrice()));
        TotalEventResult totalEventResult = new TotalEventResult(discountResult, presentationResult);
        outputView.printTotalDiscountPrice(totalEventResult.getDiscountPrice());
        outputView.printDiscountedTotalPrice(totalEventResult.getDiscountedTotalPrice(orderSheet.getTotalPrice()));
    }
}
