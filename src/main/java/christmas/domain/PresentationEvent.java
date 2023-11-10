package christmas.domain;

public class PresentationEvent {
    private static final int BASE_AMOUNT = 120000;

    private final OrderSheet orderSheet;

    public PresentationEvent(OrderSheet orderSheet) {
        this.orderSheet = orderSheet;
    }

    public boolean isDiscountable() {
        return (orderSheet.getTotalPrice() >= BASE_AMOUNT);
    }
}
