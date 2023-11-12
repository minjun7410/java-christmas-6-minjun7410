package christmas.domain.event.discount;

import christmas.domain.Day;
import christmas.domain.OrderSheet;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum DiscountEventManager {
    CHRISTMAS((day, orderSheet) -> new ChristmasDiscountEvent(day)),
    HOLIDAY((day, orderSheet) -> new HolidayDiscountEvent(day, orderSheet)),
    WEEKDAY((day, orderSheet) -> new WeekDayDiscountEvent(day, orderSheet)),
    STAR(((day, orderSheet) -> new StarDiscountEvent(day)));

    private BiFunction<Day, OrderSheet, DiscountEvent> createFunction;

    private DiscountEventManager(BiFunction<Day, OrderSheet, DiscountEvent> createFunction) {
        this.createFunction = createFunction;
    }

    public static DiscountResult getDiscountResult(Day day, OrderSheet orderSheet) {
        List<DiscountEvent> discountEvents = Arrays.stream(values())
                .map(event -> event.createFunction.apply(day, orderSheet))
                .filter(DiscountEvent::isDiscountable)
                .toList();
        return new DiscountResult(discountEvents);
    }
}
