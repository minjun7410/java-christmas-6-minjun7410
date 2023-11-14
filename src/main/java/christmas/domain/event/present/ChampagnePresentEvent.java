package christmas.domain.event.present;

import christmas.constants.AmountConstants;
import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;

public class ChampagnePresentEvent implements PresentEvent {
    private final OrderSheet orderSheet;

    public ChampagnePresentEvent(OrderSheet orderSheet) {
        this.orderSheet = orderSheet;
    }

    @Override
    public boolean isPresentable() {
        return (orderSheet.isMoreThanTotal(AmountConstants.CHAMPAGNE_PRESENT_BASE.getAmount()));
    }

    @Override
    public Menu getPresent() {
        return Menu.CHAMPAGNE;
    }
}
