package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startBridgeGame() {
        outputView.printStartGameMessage();
        Bridge bridge = initBridge();
    }

    private Bridge initBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(enterBridgeSize());
        return new Bridge(bridge);
    }

    private Integer enterBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enterBridgeSize();
        }
    }
}
