package christmas.domain;

import java.util.Map;

public class HolidayEvent {
    private static final int UNIT_AMOUNT = 2023;

    private final Day presentDay;
    private final Map<Menu, Integer> orderSheet;

    public HolidayEvent(Day presentDay, Map<Menu, Integer> orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    public boolean isDiscountable() {
        return presentDay.isHoliday();
    }
}
