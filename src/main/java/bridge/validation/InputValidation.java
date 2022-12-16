package bridge.validation;

import bridge.constants.ExceptionMessage;

public class InputValidation {

    public static Integer validateBridgeSize(String bridgeSize) {
        isExist(bridgeSize);
        return toNumber(bridgeSize);
    }

    private static void isExist(String inputValue) {
        if (inputValue.isEmpty()) {
            ExceptionMessage.NONE_INPUT.throwException();
        }
    }

    private static Integer toNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException numberFormatException) {
            ExceptionMessage.NOT_INPUT_NUMBER.throwException();
        }

        return null;
    }
}
