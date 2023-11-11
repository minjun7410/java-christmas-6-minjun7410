package christmas.domain.event.presentation;

import christmas.domain.Menu;
import christmas.domain.OrderSheet;

public class ChampagnePresentationEvent implements PresentationEvent {
    private static final int BASE_AMOUNT = 120000;

    private final OrderSheet orderSheet;

    public ChampagnePresentationEvent(OrderSheet orderSheet) {
        this.orderSheet = orderSheet;
    }

    @Override
    public boolean isPresentable() {
        return (orderSheet.getTotalPrice() >= BASE_AMOUNT);
    }

    @Override
    public Menu getPresentation() {
        return Menu.CHAMPAGNE;
    }
}