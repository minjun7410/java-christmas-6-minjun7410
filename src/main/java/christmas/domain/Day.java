package christmas.domain;

import java.util.List;

public class Day {
    private static final int START_DAY_OF_MONTH = 1;
    private static final int END_DAY_OF_MONTH = 31;
    private static final String INVALID_DAY_TEXT = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final List<Integer> starDays = List.of(3, 10, 17, 24, 25, 31);
    int day;

    public Day(int day) {
        this.day = day;
        validateDayRange();
    }

    public boolean isInBetween(int start, int end) {
        return (start <= day && day <= end);
    }

    public boolean isStarDay() {
        return starDays.contains(day);
    }

    public boolean isHoliday() {
        return DayOfWeek.isHoliday(day);
    }

    public int getDifference(Day targetDay) {
        return this.day - targetDay.day;
    }

    private void validateDayRange() {
        if (START_DAY_OF_MONTH <= day && day <= END_DAY_OF_MONTH) return;
        throw new IllegalArgumentException(INVALID_DAY_TEXT);
    }
}
