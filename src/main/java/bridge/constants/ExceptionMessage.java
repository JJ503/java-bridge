package bridge.constants;

public enum ExceptionMessage {
    NONE_INPUT("값을 입력해 주셔야 합니다."),
    NOT_INPUT_NUMBER("숫자를 입력해 주셔야 합니다."),
    NOT_INPUT_NAME_BETWEEN_3AND20("3이상 20이하의 숫자를 입력해 주셔야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
