package bridge.validation;

import bridge.constants.ExceptionMessage;

public class InputValidation {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static Integer validateBridgeSize(String bridgeSize) {
        isExist(bridgeSize);
        Integer sizeNumber = toNumber(bridgeSize);
        isBetween3And20(sizeNumber);
        return sizeNumber;
    }

    public static String validateReply(String checkValue) {
        isExist(checkValue);
        return checkValue;
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

    private static void isBetween3And20(int checkSize) {
        if (!checkBetween3And20(checkSize)) {
            ExceptionMessage.NOT_INPUT_NAME_BETWEEN_3AND20.throwException();
        }
    }

    // 조건에 맞는지 확인
    private static boolean checkBetween3And20(int checkSize) {
        return MINIMUM_BRIDGE_SIZE <= checkSize && checkSize < MAXIMUM_BRIDGE_SIZE;
    }
}
