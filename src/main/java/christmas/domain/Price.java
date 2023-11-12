package christmas.domain;

import java.text.DecimalFormat;

public class Price {
    private final int price;

    public Price(int price) {
        this.price = price;
    }

    private String addComma(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }

    @Override
    public String toString() {
        return addComma(price);
    }
}
