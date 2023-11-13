package christmas.domain.event.present;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;

public class ChampagnePresentEvent implements PresentEvent {
    private static final int BASE_AMOUNT = 120000;

    private final OrderSheet orderSheet;

    public ChampagnePresentEvent(OrderSheet orderSheet) {
        this.orderSheet = orderSheet;
    }

    @Override
    public boolean isPresentable() {
        return (orderSheet.isMoreThanTotal(BASE_AMOUNT));
    }

    @Override
    public Menu getPresent() {
        return Menu.CHAMPAGNE;
    }
}
