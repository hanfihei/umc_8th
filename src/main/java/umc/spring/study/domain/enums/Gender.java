package umc.spring.study.domain.enums;


public enum Gender {
    MALE, FEMALE, NONE;

    public static Gender fromCode(int code) {
        return switch (code) {
            case 1 -> MALE;
            case 2 -> FEMALE;
            case 3 -> NONE;
            default -> throw new IllegalArgumentException("Invalid gender code: " + code);
        };
    }
}
