package christmas.domain.event.discount;

import christmas.domain.Day;
import christmas.domain.MenuType;
import christmas.domain.OrderSheet;

public class HolidayDiscountEvent implements DiscountEvent {
    private static final int UNIT_AMOUNT = 2023;

    private final Day presentDay;
    private final OrderSheet orderSheet;

    public HolidayDiscountEvent(Day presentDay, OrderSheet orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    @Override
    public boolean isDiscountable() {
        return presentDay.isHoliday();
    }

    @Override
    public int getDiscountedAmount() {
        int menuCount = orderSheet.getMenuCountByMenuType(MenuType.MAIN);
        return UNIT_AMOUNT * menuCount;
    }
}
