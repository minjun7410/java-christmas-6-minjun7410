package christmas.domain;

public enum WeekDay {

    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3),
    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    THURSDAY(7),
    NOT_DAY(8);

    private int firstDay;
    private WeekDay(int firstDay) {
        this.firstDay = firstDay;
    }

    public static boolean isHoliday(int day) {
        WeekDay weekDay = getWeekDay(day);
        return (weekDay == FRIDAY || weekDay == SATURDAY);
    }

    private static WeekDay getWeekDay(int day) {
        for (WeekDay weekDay : WeekDay.values()) {
            if ((weekDay.firstDay % 7) == (day % 7)) return weekDay;
        }
        return NOT_DAY;
    }
}
