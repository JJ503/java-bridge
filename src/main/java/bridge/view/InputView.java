package bridge.view;

import bridge.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "\n다리의 길이를 입력해주세요.";

    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        return InputValidation.validateBridgeSize(Console.readLine());
    }

    public String readMoving() {
        return InputValidation.validateReply(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return InputValidation.validateReply(Console.readLine());
    }
}
