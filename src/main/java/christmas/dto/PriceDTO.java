package christmas.dto;

import christmas.domain.Price;

public class PriceDTO {
    private final String price;

    public PriceDTO(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public static PriceDTO from(int price) {
        return from(new Price(price));
    }

    public static PriceDTO from(Price price) {
        return new PriceDTO(price.toString());
    }
}
