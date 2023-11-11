package christmas.domain.event.discount;

import java.util.List;

public class DiscountResult {
    private final List<DiscountEvent> discountEvents;

    public DiscountResult(List<DiscountEvent> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public int getTotalDiscountAmount() {
        return discountEvents.stream()
                .map(DiscountEvent::getDiscountedAmount)
                .reduce(0, Integer::sum);
    }
}
