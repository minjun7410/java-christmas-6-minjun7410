package christmas;

import christmas.domain.Day;
import christmas.domain.OrderSheet;
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
}
