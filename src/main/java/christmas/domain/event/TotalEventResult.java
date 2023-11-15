package christmas.domain.event;

import christmas.domain.Badge;
import christmas.domain.Price;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.present.PresentResult;
import christmas.dto.PriceDTO;

public class TotalEventResult {
    private final DiscountResult discountResult;
    private final PresentResult presentResult;

    public TotalEventResult(DiscountResult discountResult, PresentResult presentResult) {
        this.discountResult = discountResult;
        this.presentResult = presentResult;
    }

    public PriceDTO getDiscountPrice() {
        return PriceDTO.from(calculateTotalPriceAmount());
    }

    public PriceDTO getDiscountedPrice(Price price) {
        price.discount(discountResult.getTotalDiscountAmount());
        return PriceDTO.from(price);
    }

    public Badge getBadge() {
        return Badge.getBadgeByDiscountedAmount(
                calculateTotalPriceAmount());
    }

    private int calculateTotalPriceAmount() {
        return discountResult.getTotalDiscountAmount() + presentResult.getTotalPresentPrice();
    }
}
