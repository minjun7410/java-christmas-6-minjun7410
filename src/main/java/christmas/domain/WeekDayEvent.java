package christmas.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeekDayEvent {
    private static final int UNIT_AMOUNT = 2023;

    private final Day presentDay;
    private final Map<Menu, Integer> orderSheet;

    public WeekDayEvent(Day presentDay, Map<Menu, Integer> orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    public boolean isDiscountable() {
        return !(presentDay.isHoliday());
    }

    public int getDiscountedAmount() {
        int discountedAmount = orderSheet.keySet().stream()
                .filter(menu -> menu.compareType(MenuType.DESERT))
                .map(orderSheet::get)
                .reduce(0, Integer::sum);
        return UNIT_AMOUNT * discountedAmount;
    }
}
