package christmas.domain.event.presentation;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum PresentationEventManager {
    CHAMPAGNE((orderSheet) -> new ChampagnePresentationEvent(orderSheet));

    private Function<OrderSheet, PresentationEvent> createFunction;

    PresentationEventManager(Function<OrderSheet, PresentationEvent> createFunction) {
        this.createFunction = createFunction;
    }

    public static PresentationResult getPresentations(OrderSheet orderSheet) {
        List<Menu> presentations =  Arrays.stream(values())
                .map(presentationEvent -> presentationEvent.createFunction.apply(orderSheet))
                .filter(PresentationEvent::isPresentable)
                .map(PresentationEvent::getPresentation)
                .toList();
        return new PresentationResult(presentations);
    }
}
