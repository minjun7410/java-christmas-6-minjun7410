package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int baseDiscountedAmount;

    Badge(String name, int baseDiscountedAmount) {
        this.name = name;
        this.baseDiscountedAmount = baseDiscountedAmount;
    }

    public static Badge getBadgeByDiscountedAmount(int discountedAmount) {
        for (Badge badge : Badge.values()) {
            if (badge.baseDiscountedAmount <= discountedAmount) return badge;
        }
        return NONE;
    }
}
