package christmas;

import christmas.domain.Price;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PriceTest {
    @Test
    void 쉼표로_끊는_기능_테스트() {
        Price price = new Price(1000000);
        String priceText = price.toString();
        assertThat(getMatchCount(priceText, ",")).isEqualTo(2);
    }

    private int getMatchCount(String input, String target) {
        String replacedInput = input.replace(target, "");
        return input.length() - replacedInput.length();
    }
}
