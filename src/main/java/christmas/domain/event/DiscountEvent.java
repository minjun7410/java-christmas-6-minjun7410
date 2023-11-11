package christmas.domain.event;

public interface DiscountEvent {
    public boolean isDiscountable();

    public int getDiscountedAmount();
}
