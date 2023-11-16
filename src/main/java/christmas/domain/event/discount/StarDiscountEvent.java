package christmas.domain.event.discount;

import christmas.constants.AmountConstants;
import christmas.domain.day.Day;

public class StarDiscountEvent implements DiscountEvent {
    private final Day presentDay;

    public StarDiscountEvent(Day presentDay) {
        this.presentDay = presentDay;
    }

    @Override
    public boolean isDiscountable() {
        return presentDay.isStarDay();
    }

    @Override
    public int getDiscountedAmount() {
        return AmountConstants.STAR_DISCOUNT.getAmount();
    }

    @Override
    public String toString() {
        return "특별 할인";
    }
}
