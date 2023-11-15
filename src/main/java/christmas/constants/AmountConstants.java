package christmas.constants;

public enum AmountConstants {
    CHRISTMAS_BASE(1_000),
    CHRISTMAS_UNIT(100),
    DISCOUNT_THRESHOLD(10_000),
    HOLIDAY_UNIT(2_023),
    STAR_DISCOUNT(1_000),
    WEEKDAY_UNIT(2_023),
    CHAMPAGNE_PRESENT_BASE(120_000);

    private final int amount;

    AmountConstants(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
