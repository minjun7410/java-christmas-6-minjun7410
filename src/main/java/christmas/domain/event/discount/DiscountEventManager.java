package christmas.domain.event.discount;

import christmas.constants.AmountConstants;
import christmas.domain.day.Day;
import christmas.domain.order.OrderSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DiscountEventManager {
    CHRISTMAS {
        @Override
        protected DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new ChristmasDiscountEvent(day);
        }
    },
    HOLIDAY {
        @Override
        protected DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new HolidayDiscountEvent(day, orderSheet);
        }
    },
    WEEKDAY {
        @Override
        protected DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new WeekDayDiscountEvent(day, orderSheet);
        }
    },
    STAR{
        @Override
        protected DiscountEvent create(Day day, OrderSheet orderSheet) {
            return new StarDiscountEvent(day);
        }
    };

    abstract protected DiscountEvent create(Day day, OrderSheet orderSheet);

    public static DiscountResult getDiscountResult(Day day, OrderSheet orderSheet) {
        if (orderSheet.isMoreThanTotal(AmountConstants.DISCOUNT_THRESHOLD.getAmount())) {
            List<DiscountEvent> discountEvents = Arrays.stream(values())
                    .map(event -> event.create(day, orderSheet))
                    .filter(DiscountEvent::isDiscountable)
                    .toList();
            return new DiscountResult(discountEvents);
        }
        return new DiscountResult(new ArrayList<>());
    }
}
