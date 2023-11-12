package christmas.domain.event.discount;

import christmas.domain.Day;

public class ChristmasDiscountEvent implements DiscountEvent {
    private static final int START_DAY = 1;
    private static final int END_DAY = 25;
    private static final int BASE_AMOUNT = 1000;
    private static final int UNIT_AMOUNT = 100;

    private final Day presentDay;
    private final Day startDay;

    public ChristmasDiscountEvent(Day presentDay) {
        this.presentDay = presentDay;
        this.startDay = new Day(START_DAY);
    }

    @Override
    public boolean isDiscountable() {
        return presentDay.isInBetween(START_DAY, END_DAY);
    }

    @Override
    public int getDiscountedAmount() {
        int dayDifference = presentDay.getDifference(startDay);
        return BASE_AMOUNT + (UNIT_AMOUNT * dayDifference);
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인";
    }
}
