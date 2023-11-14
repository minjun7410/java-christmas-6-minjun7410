package christmas.dto;

public class DiscountEventDTO {
    private String eventName;
    private int price;

    public DiscountEventDTO(String eventName, int price) {
        this.eventName = eventName;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public int getPrice() {
        return price;
    }
}
