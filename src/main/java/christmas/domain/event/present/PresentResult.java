package christmas.domain.event.present;

import christmas.domain.order.Menu;

import java.util.Map;

public class PresentResult {
    private final Map<Menu, Integer> presents;

    public PresentResult(Map<Menu, Integer> presents) {
        this.presents = presents;
    }

    public Map<Menu, Integer> getPresents() {
        return presents;
    }

    public int getTotalPresentPrice() {
        return presents.keySet().stream()
                .map(menu -> menu.getPrice() * presents.get(menu))
                .reduce(0, Integer::sum);
    }
}
