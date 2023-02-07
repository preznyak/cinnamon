package hu.preznyak.hotel.cinnamon.data;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Gender fromValue(String value) {
        switch (value) {
            case "Male": {
                return Gender.MALE;
            }
            case "Female": {
                return Gender.FEMALE;
            }
            default:
                throw new IllegalArgumentException("Value [" + value + "] not supported.");

        }
    }
}
