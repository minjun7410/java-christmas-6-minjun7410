package christmas.domain.event.present;

import christmas.domain.order.Menu;
import christmas.domain.order.OrderSheet;

import java.util.HashMap;
import java.util.Map;

public enum PresentEventManager {
    CHAMPAGNE {
        @Override
        protected PresentEvent create(OrderSheet orderSheet) {
            return new ChampagnePresentEvent(orderSheet);
        }
    };

    abstract protected PresentEvent create(OrderSheet orderSheet);

    public static PresentResult getPresentResult(OrderSheet orderSheet) {
        Map<Menu, Integer> presents = new HashMap<>();
        for (PresentEventManager value : values()) {
            PresentEvent event = value.create(orderSheet);
            if (event.isPresentable()) {
                int presentCount = presents.getOrDefault(event.getPresent(), 1);
                presents.put(event.getPresent(), presentCount);
            }
        }
        return new PresentResult(presents);
    }
}
