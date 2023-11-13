package christmas.domain.event.presentation;

import christmas.domain.order.Menu;

import java.util.Map;

public class PresentationResult {
    private final Map<Menu, Integer> presentations;

    public PresentationResult(Map<Menu, Integer> presentations) {
        this.presentations = presentations;
    }

    public Map<Menu, Integer> getPresentations() {
        return presentations;
    }

    public int getTotalPresentationPrice() {
        return presentations.keySet().stream()
                .map(menu -> menu.getPrice() * presentations.get(menu))
                .reduce(0, Integer::sum);
    }
}
