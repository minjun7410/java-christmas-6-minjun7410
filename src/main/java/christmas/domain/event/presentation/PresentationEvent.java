package christmas.domain.event.presentation;

import christmas.domain.Menu;

public interface PresentationEvent {
    public boolean isPresentable();

    public Menu getPresentation();
}
