package christmas.domain;

public class Day {
    int day;

    public Day(int day) {
        this.day = day;
    }

    public boolean isInBetween(int start, int end) {
        return (start <= day && day <= end);
    }
}
