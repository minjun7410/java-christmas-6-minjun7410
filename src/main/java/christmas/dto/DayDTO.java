package christmas.dto;

import christmas.domain.day.Day;

public class DayDTO {
    private final int day;

    public DayDTO(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
