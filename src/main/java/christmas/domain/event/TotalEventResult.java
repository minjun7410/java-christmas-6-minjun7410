package christmas.domain.event;

import christmas.domain.Badge;
import christmas.domain.Price;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.presentation.PresentationResult;

public class TotalEventResult {
    private final DiscountResult discountResult;
    private final PresentationResult presentationResult;
    private int totalDiscountAmount;

    public TotalEventResult(DiscountResult discountResult, PresentationResult presentationResult) {
        this.discountResult = discountResult;
        this.presentationResult = presentationResult;
        calculateTotalPriceAmount();
    }

    public Price getDiscountPrice() {
        return new Price(totalDiscountAmount);
    }

    public Price getDiscountedTotalPrice(Price price) {
        price.discount(discountResult.getTotalDiscountAmount());
        return price;
    }

    public Badge getBadge() {
        return Badge.getBadgeByDiscountedAmount(totalDiscountAmount);
    }

    private void calculateTotalPriceAmount() {
        totalDiscountAmount = discountResult.getTotalDiscountAmount() + presentationResult.getTotalPresentationPrice();
    }
}
