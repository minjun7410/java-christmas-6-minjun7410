package christmas.dto;

import christmas.domain.Badge;

public class BadgeDTO {
    private final String badgeName;

    public BadgeDTO(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public static BadgeDTO from(Badge badge) {
        return new BadgeDTO(badge.toString());
    }
}
