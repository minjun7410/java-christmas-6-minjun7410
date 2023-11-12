package christmas.domain;

import java.text.DecimalFormat;

public class Price {
    private int price;

    public Price(int price) {
        this.price = price;
    }

    public void discount(int discountAmount) {
        this.price -= discountAmount;
        this.price = getItOrZero(this.price);
    }

    private String addComma(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }

    private int getItOrZero(int price) {
        return Math.max(price, 0);
    }

    @Override
    public String toString() {
        return addComma(price);
    }
}
