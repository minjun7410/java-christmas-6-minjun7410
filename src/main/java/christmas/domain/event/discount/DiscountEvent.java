package christmas.domain.event.discount;

public interface DiscountEvent {
    public boolean isDiscountable();

    public int getDiscountedAmount();

    @Override
    public String toString();
}
