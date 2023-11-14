package christmas.domain.event.discount;

import christmas.domain.Price;
import christmas.dto.DiscountEventDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountResult {
    private final List<DiscountEvent> discountEvents;

    public DiscountResult(List<DiscountEvent> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public List<DiscountEventDTO> getDiscountEvents() {
        List<DiscountEventDTO> discountEventDTOs = new ArrayList<>();
        for (DiscountEvent event : discountEvents) {
            discountEventDTOs.add(new DiscountEventDTO(event.toString(), event.getDiscountedAmount()));
        }
        return discountEventDTOs;
    }
    
    public int getTotalDiscountAmount() {
        return discountEvents.stream()
                .map(DiscountEvent::getDiscountedAmount)
                .reduce(0, Integer::sum);
    }
}
