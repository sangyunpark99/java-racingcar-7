package domain;

public class Car {

    private static final String MAXIMUM_NAME_SIZE_ERROR_MESSAGE = "자동차 이름은 5글자 이하로 입력해야 합니다";
    private static final Integer MAXIMUM_NAME_SIZE = 6;

    private final String name;

    public Car(final String name) {
        validateNameSize(name);
        this.name = name;
    }

    public void validateNameSize(final String name) {
        if(name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException(MAXIMUM_NAME_SIZE_ERROR_MESSAGE);
        }
    }
}