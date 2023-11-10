package christmas.domain;

public enum Menu {
    MUSHROOMSOUP("양송이수프", 6000, MenuType.APPETIZER),
    TAPAS("타파스", 5500, MenuType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 5500, MenuType.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuType.MAIN),
    BBQ_LIP("바베큐립", 54000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
    CHRISMAS_PASTA("크리스마스파스타", 25000, MenuType.MAIN),
    CHOCO_CAKE("초코케이크", 15000, MenuType.DESERT),
    ICECREAM("아이스크림", 5000, MenuType.DESERT),
    ZERO_COLA("제로콜라", 3000, MenuType.DRINK),
    RED_WINE("레드와인", 60000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25000, MenuType.DRINK);

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

    public static Menu getMenuByName(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(menuName)) return menu;
        }
        throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
