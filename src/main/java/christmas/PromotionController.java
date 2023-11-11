package christmas;

import christmas.domain.Day;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Day orderDay = getOrderDay();
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
}
