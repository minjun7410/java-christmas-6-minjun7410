package christmas.constants;

public enum DayConstants {
    START_OF_MONTH(1),
    END_OF_MONTH(31),
    CHRISTMAS_START(1),
    CHRISTMAS_END(25);

    private final int day;

    DayConstants(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
