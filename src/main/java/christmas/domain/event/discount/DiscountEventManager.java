package christmas.domain.event.discount;

import christmas.domain.Day;
import christmas.domain.OrderSheet;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum DiscountEventManager {
    CHRISTMAS {
        public DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new ChristmasDiscountEvent(day);
        }
    },
    HOLIDAY {
        public DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new HolidayDiscountEvent(day, orderSheet);
        }
    },
    WEEKDAY {
        public DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new WeekDayDiscountEvent(day, orderSheet);
        }
    },
    STAR{
        public DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new StarDiscountEvent(day);
        }
    };

    abstract protected DiscountEvent create(Day day, OrderSheet orderSheet);

    public static DiscountResult getDiscountResult(Day day, OrderSheet orderSheet) {
        if (orderSheet.isMoreThanTotal(10000)) {
            List<DiscountEvent> discountEvents = Arrays.stream(values())
                    .map(event -> event.create(day, orderSheet))
                    .filter(DiscountEvent::isDiscountable)
                    .toList();
            return new DiscountResult(discountEvents);
        }
        return new DiscountResult(new ArrayList<>());
    }
}
