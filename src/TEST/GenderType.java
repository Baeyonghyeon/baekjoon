package TEST;

public enum GenderType {
    MAN("남성"),
    WOMAN("여성");

    private final String type;

    GenderType(String type) {
        this.type = type;
    }
}