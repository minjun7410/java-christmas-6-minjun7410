package christmas.event;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PriceTest {
    @Test
    void 쉼표로_끊는_기느() {
        Price price = new Price(1000000);
        String priceText = price.toString();
        assertThat(getMatchCount(priceText, ",")).isEqualTo(2);
    }

    private int getMatchCount(String input, String target) {
        String replacedInput = input.replace(target, "");
        return input.length() - replacedInput.length();
    }
}
