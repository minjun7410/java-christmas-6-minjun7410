package christmas.domain.event.presentation;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum PresentationEventManager {
    CHAMPAGNE((orderSheet) -> new ChampagnePresentationEvent(orderSheet));

    private Function<OrderSheet, PresentationEvent> createFunction;

    PresentationEventManager(Function<OrderSheet, PresentationEvent> createFunction) {
        this.createFunction = createFunction;
    }

    public static PresentationResult getPresentationResult(OrderSheet orderSheet) {
        Map<Menu, Integer> presentations = new HashMap<>();
        for (PresentationEventManager value : values()) {
            PresentationEvent event = value.createFunction.apply(orderSheet);
            if (event.isPresentable()) {
                int presentationCount = presentations.getOrDefault(event.getPresentation(), 1);
                presentations.put(event.getPresentation(), presentationCount);
            }
        }
        return new PresentationResult(presentations);
    }
}
