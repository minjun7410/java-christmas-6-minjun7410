package christmas.domain.event;

import christmas.domain.Badge;
import christmas.domain.Price;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.present.PresentResult;

public class TotalEventResult {
    private final DiscountResult discountResult;
    private final PresentResult presentResult;

    public TotalEventResult(DiscountResult discountResult, PresentResult presentResult) {
        this.discountResult = discountResult;
        this.presentResult = presentResult;
    }

    public Price getDiscountPrice() {
        return new Price(calculateTotalPriceAmount());
    }

    public Price getDiscountedTotalPrice(Price price) {
        price.discount(discountResult.getTotalDiscountAmount());
        return price;
    }

    public Badge getBadge() {
        return Badge.getBadgeByDiscountedAmount(
                calculateTotalPriceAmount());
    }

    private int calculateTotalPriceAmount() {
        return discountResult.getTotalDiscountAmount() + presentResult.getTotalPresentPrice();
    }
}
