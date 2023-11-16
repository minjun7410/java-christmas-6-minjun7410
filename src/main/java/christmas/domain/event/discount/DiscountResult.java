package christmas.domain.event.discount;

import christmas.dto.DiscountResultDTO;

import java.util.ArrayList;
import java.util.List;

public class DiscountResult {
    private final List<DiscountEvent> discountEvents;

    public DiscountResult(List<DiscountEvent> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public List<DiscountResultDTO> getDiscountResults() {
        List<DiscountResultDTO> discountResultDTOS = new ArrayList<>();
        for (DiscountEvent event : discountEvents) {
            discountResultDTOS.add(new DiscountResultDTO(event.toString(), event.getDiscountedAmount()));
        }
        return discountResultDTOS;
    }
    
    public int getTotalDiscountAmount() {
        return discountEvents.stream()
                .map(DiscountEvent::getDiscountedAmount)
                .reduce(0, Integer::sum);
    }
}
