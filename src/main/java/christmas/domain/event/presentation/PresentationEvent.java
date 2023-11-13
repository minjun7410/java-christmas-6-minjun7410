package christmas.domain.event.presentation;

import christmas.domain.order.Menu;

public interface PresentationEvent {
    public boolean isPresentable();

    public Menu getPresentation();
}
