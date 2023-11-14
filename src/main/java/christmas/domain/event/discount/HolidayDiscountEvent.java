package christmas.domain.event.discount;

import christmas.constants.AmountConstants;
import christmas.domain.day.Day;
import christmas.domain.order.MenuType;
import christmas.domain.order.OrderSheet;

public class HolidayDiscountEvent implements DiscountEvent {
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
        return AmountConstants.HOLIDAY_UNIT.getAmount() * menuCount;
    }

    @Override
    public String toString() {
        return "주말 할인";
    }
}
