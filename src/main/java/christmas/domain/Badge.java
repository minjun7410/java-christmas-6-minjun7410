package christmas.domain;

import christmas.dto.BadgeDTO;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String name;
    private final int baseDiscountedAmount;

    Badge(String name, int baseDiscountedAmount) {
        this.name = name;
        this.baseDiscountedAmount = baseDiscountedAmount;
    }

    public static BadgeDTO getBadgeByDiscountedAmount(int discountedAmount) {
        for (Badge badge : Badge.values()) {
            if (badge.baseDiscountedAmount <= discountedAmount) return BadgeDTO.from(badge);
        }
        return BadgeDTO.from(NONE);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
