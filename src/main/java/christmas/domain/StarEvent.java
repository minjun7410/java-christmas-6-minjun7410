package christmas.domain;

public class StarEvent {
    private final Day presentDay;

    public StarEvent(Day presentDay) {
        this.presentDay = presentDay;
    }

    public boolean isDiscountable() {
        return presentDay.isStarDay();
    }
}
