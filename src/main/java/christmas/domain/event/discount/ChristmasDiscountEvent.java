package christmas.domain.event.discount;

import christmas.constants.AmountConstants;
import christmas.constants.DayConstants;
import christmas.domain.day.Day;

public class ChristmasDiscountEvent implements DiscountEvent {
    private final Day presentDay;
    private final Day startDay;

    public ChristmasDiscountEvent(Day presentDay) {
        this.presentDay = presentDay;
        this.startDay = new Day(DayConstants.CHRISTMAS_START.getDay());
    }

    @Override
    public boolean isDiscountable() {
        return presentDay.isInBetween(DayConstants.CHRISTMAS_START.getDay(), DayConstants.CHRISTMAS_END.getDay());
    }

    @Override
    public int getDiscountedAmount() {
        int dayDifference = presentDay.getDifference(startDay);
        return AmountConstants.CHRISTMAS_BASE.getAmount() + (AmountConstants.CHRISTMAS_UNIT.getAmount() * dayDifference);
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인";
    }
}
