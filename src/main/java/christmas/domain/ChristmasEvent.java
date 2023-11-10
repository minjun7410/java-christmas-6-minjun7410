package christmas.domain;

public class ChristmasEvent {
    private static final int START_DAY = 1;
    private static final int BASE_AMOUNT = 1000;
    private static final int UNIT_AMOUNT = 100;

    private final Day presentDay;
    private final Day startDay;

    public ChristmasEvent(Day presentDay) {
        this.presentDay = presentDay;
        this.startDay = new Day(START_DAY);
    }

    public int getDiscountedAmount() {
        int dayDifference = presentDay.getDifference(startDay);
        return BASE_AMOUNT + (UNIT_AMOUNT * dayDifference);
    }
}
