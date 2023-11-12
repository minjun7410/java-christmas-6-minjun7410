package christmas.domain.event.discount;

import christmas.domain.Price;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountResult {
    private final List<DiscountEvent> discountEvents;

    public DiscountResult(List<DiscountEvent> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public Map<DiscountEvent, Price> getDiscountEvents() {
        Map<DiscountEvent, Price> discountEventPrice = new HashMap<>();
        for (DiscountEvent event : discountEvents) {
            discountEventPrice.put(event, new Price(event.getDiscountedAmount()));
        }
        return discountEventPrice;
    }
    
    public int getTotalDiscountAmount() {
        return discountEvents.stream()
                .map(DiscountEvent::getDiscountedAmount)
                .reduce(0, Integer::sum);
    }
}
