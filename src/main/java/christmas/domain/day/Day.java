package christmas.domain.day;

import christmas.constants.DayConstants;
import christmas.constants.ErrorMessage;
import christmas.dto.DayDTO;

import java.util.List;

public class Day {
    private final List<Integer> starDays = List.of(3, 10, 17, 24, 25, 31);
    private final int day;

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

    public DayDTO getDay() {
        return new DayDTO(day);
    }

    private void validateDayRange() {
        if (DayConstants.START_OF_MONTH.getDay() <= day && day <= DayConstants.END_OF_MONTH.getDay()) return;
        throw new IllegalArgumentException(ErrorMessage.INVALID_DAY_RANGE.getErrorMessage());
    }
}
