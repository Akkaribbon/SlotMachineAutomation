package utilities;

public enum BackgroundTypes {

    BACKGROUND_GRAY ("#changeable_background_1"),
    BACKGROUND_SEA ("#changeable_background_2"),
    BACKGROUND_CANDY ("#changeable_background_3"),
    BACKGROUND_BLUE ("#changeable_background_4");

    public String value;

    BackgroundTypes (String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
