package christmas.domain.event.discount;

import christmas.domain.day.Day;

public class StarDiscountEvent implements DiscountEvent {
    private static final int DISCOUNT_AMOUNT = 1000;
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
        return DISCOUNT_AMOUNT;
    }

    @Override
    public String toString() {
        return "특별 할인";
    }
}
