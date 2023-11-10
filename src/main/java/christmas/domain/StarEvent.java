package christmas.domain;

public class StarEvent {
    private static final int DISCOUNT_AMOUNT = 1000;
    private final Day presentDay;

    public StarEvent(Day presentDay) {
        this.presentDay = presentDay;
    }

    public boolean isDiscountable() {
        return presentDay.isStarDay();
    }

    public int getDiscountedAmount() {
        return DISCOUNT_AMOUNT;
    }
}
