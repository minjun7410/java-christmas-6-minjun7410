package christmas.domain.event.presentation;

import christmas.domain.Menu;

import java.util.List;

public class PresentationResult {
    private final List<Menu> presentations;

    public PresentationResult(List<Menu> presentations) {
        this.presentations = presentations;
    }

    public List<Menu> getPresentations() {
        return presentations;
    }

    public int getTotalPresentationPrice() {
        return presentations.stream()
                .map(Menu::getPrice)
                .reduce(0, Integer::sum);
    }
}
