package christmas.domain.order;

public enum Menu {
    MUSHROOMSOUP("양송이수프", 6_000, MenuType.APPETIZER),
    TAPAS("타파스", 5_500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 5_500, MenuType.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55_000, MenuType.MAIN),
    BBQ_LIP("바비큐립", 54_000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuType.MAIN),
    CHRISMAS_PASTA("크리스마스파스타", 25_000, MenuType.MAIN),
    CHOCO_CAKE("초코케이크", 15_000, MenuType.DESERT),
    ICECREAM("아이스크림", 5_000, MenuType.DESERT),
    ZERO_COLA("제로콜라", 3_000, MenuType.DRINK),
    RED_WINE("레드와인", 60_000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuType.DRINK);

    private final String name;
    private final int price;
    private final MenuType menuType;

    Menu(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public boolean compareType(MenuType menuType) {
        return (this.menuType == menuType);
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public static Menu getMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(menuName)) return menu;
        }
        throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
