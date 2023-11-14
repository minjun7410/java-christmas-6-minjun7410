package christmas.dto;

public class DiscountResultDTO {
    private String eventName;
    private int price;

    public DiscountResultDTO(String eventName, int price) {
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
