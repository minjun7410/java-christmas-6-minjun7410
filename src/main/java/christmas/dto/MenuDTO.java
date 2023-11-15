package christmas.dto;

public class MenuDTO {
    private final String menuName;
    private final int count;

    public MenuDTO(String menuName, int count) {
        this.menuName = menuName;
        this.count = count;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getCount() {
        return count;
    }
}
