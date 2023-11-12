package christmas.domain.event;

import christmas.domain.Price;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.presentation.PresentationResult;

public class TotalEventResult {
    private final DiscountResult discountResult;
    private final PresentationResult presentationResult;

    public TotalEventResult(DiscountResult discountResult, PresentationResult presentationResult) {
        this.discountResult = discountResult;
        this.presentationResult = presentationResult;
    }

    public Price getDiscountPrice() {
        int totalPriceAmount = discountResult.getTotalDiscountAmount() + presentationResult.getTotalPresentationPrice();
        return new Price(totalPriceAmount);
    }
}
