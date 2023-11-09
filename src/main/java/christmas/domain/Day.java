package christmas.domain;

import java.util.List;

public class Day {
    private final List<Integer> starDays = List.of(3, 10, 17, 24, 25, 31);
    int day;

    public Day(int day) {
        this.day = day;
    }

    public boolean isInBetween(int start, int end) {
        return (start <= day && day <= end);
    }

    public boolean isStarDay() {
        return starDays.contains(day);
    }
}
