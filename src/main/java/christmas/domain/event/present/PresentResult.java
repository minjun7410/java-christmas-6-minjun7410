package christmas.domain.event.present;

import christmas.domain.order.Menu;
import christmas.dto.PresentResultDTO;

import java.util.List;
import java.util.Map;

public class PresentResult {
    private final Map<Menu, Integer> presents;

    public PresentResult(Map<Menu, Integer> presents) {
        this.presents = presents;
    }

    public List<PresentResultDTO> getPresents() {
        return presents.keySet().stream()
                .map(menu -> new PresentResultDTO(menu.getName(), presents.get(menu)))
                .toList();
    }

    public int getTotalPresentPrice() {
        return presents.keySet().stream()
                .map(menu -> menu.getPrice() * presents.get(menu))
                .reduce(0, Integer::sum);
    }
}
