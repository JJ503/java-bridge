package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startBridgeGame() {
        outputView.printStartGameMessage();
    }
}
