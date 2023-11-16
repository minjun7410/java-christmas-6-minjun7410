package christmas.dto;

public class PresentResultDTO {
    private final String presentName;

    private final int count;

    public PresentResultDTO(String presentName, int count) {
        this.presentName = presentName;
        this.count = count;
    }

    public String getPresentName() {
        return presentName;
    }

    public int getCount() {
        return count;
    }
}
