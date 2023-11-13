package christmas.domain.day;

public enum DayOfWeek {

    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3),
    MONDAY(4),
    TUESDAY(5),
    WEDNESDAY(6),
    THURSDAY(7),
    NOT_DAY(8);

    private int firstDay;
    private DayOfWeek(int firstDay) {
        this.firstDay = firstDay;
    }

    public static boolean isHoliday(int day) {
        DayOfWeek dayOfWeek = getDayOfWeekByDay(day);
        return (dayOfWeek == FRIDAY || dayOfWeek == SATURDAY);
    }

    private static DayOfWeek getDayOfWeekByDay(int day) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if ((dayOfWeek.firstDay % 7) == (day % 7)) return dayOfWeek;
        }
        return NOT_DAY;
    }
}
