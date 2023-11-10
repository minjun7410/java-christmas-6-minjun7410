package christmas.domain;

import java.util.Map;

public class WeekDayEvent {
    private final Day presentDay;
    private final Map<Menu, Integer> orderSheet;

    public WeekDayEvent(Day presentDay, Map<Menu, Integer> orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    public boolean isDiscountable() {
        return !(presentDay.isHoliday());
    }
}
