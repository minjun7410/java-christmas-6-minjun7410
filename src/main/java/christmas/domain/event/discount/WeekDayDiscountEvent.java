package christmas.domain.event.discount;

import christmas.constants.AmountConstants;
import christmas.domain.day.Day;
import christmas.domain.order.MenuType;
import christmas.domain.order.OrderSheet;

public class WeekDayDiscountEvent implements DiscountEvent {
    private final Day presentDay;
    private final OrderSheet orderSheet;

    public WeekDayDiscountEvent(Day presentDay, OrderSheet orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    @Override
    public boolean isDiscountable() {
        return !(presentDay.isHoliday());
    }

    @Override
    public int getDiscountedAmount() {
        int menuCount = orderSheet.getMenuCountByMenuType(MenuType.DESERT);
        return AmountConstants.WEEKDAY_UNIT.getAmount() * menuCount;
    }

    @Override
    public String toString() {
        return "평일 할인";
    }
}
