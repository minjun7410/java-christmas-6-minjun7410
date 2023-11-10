package christmas.domain;

import java.util.Map;

public class WeekDayEvent {
    private static final int UNIT_AMOUNT = 2023;

    private final Day presentDay;
    private final OrderSheet orderSheet;

    public WeekDayEvent(Day presentDay, OrderSheet orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    public boolean isDiscountable() {
        return !(presentDay.isHoliday());
    }

    public int getDiscountedAmount() {
        int menuCount = orderSheet.getMenuCountByMenuType(MenuType.DESERT);
        return UNIT_AMOUNT * menuCount;
    }
}
