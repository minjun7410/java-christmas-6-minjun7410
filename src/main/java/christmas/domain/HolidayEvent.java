package christmas.domain;

public class HolidayEvent {
    private static final int UNIT_AMOUNT = 2023;

    private final Day presentDay;
    private final OrderSheet orderSheet;

    public HolidayEvent(Day presentDay, OrderSheet orderSheet) {
        this.presentDay = presentDay;
        this.orderSheet = orderSheet;
    }

    public boolean isDiscountable() {
        return presentDay.isHoliday();
    }

    public int getDiscountedAmount() {
        int menuCount = orderSheet.getMenuCountByMenuType(MenuType.MAIN);
        return UNIT_AMOUNT * menuCount;
    }
}
