package christmas.domain.event.presentation;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;

import java.util.HashMap;
import java.util.Map;

public enum PresentationEventManager {
    CHAMPAGNE {
        @Override
        protected PresentationEvent create(OrderSheet orderSheet) {
            return new ChampagnePresentationEvent(orderSheet);
        }
    };

    abstract protected PresentationEvent create(OrderSheet orderSheet);

    public static PresentationResult getPresentationResult(OrderSheet orderSheet) {
        Map<Menu, Integer> presentations = new HashMap<>();
        for (PresentationEventManager value : values()) {
            PresentationEvent event = value.create(orderSheet);
            if (event.isPresentable()) {
                int presentationCount = presentations.getOrDefault(event.getPresentation(), 1);
                presentations.put(event.getPresentation(), presentationCount);
            }
        }
        return new PresentationResult(presentations);
    }
}
