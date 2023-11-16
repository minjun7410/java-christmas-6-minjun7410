package christmas.domain.event.present;

import christmas.domain.order.Menu;

public interface PresentEvent {
    public boolean isPresentable();

    public Menu getPresent();
}
