package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constants.Reply;
import bridge.model.Bridge;
import bridge.model.TryCount;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.platform.commons.function.Try;

import java.util.List;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startBridgeGame() {
        outputView.printStartGameMessage();
        Bridge bridge = initBridge();
        proceedGame(bridge);
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

    private void proceedGame(Bridge bridge) {
        boolean gameState = true;
        BridgeGame bridgeGame = new BridgeGame(bridge);
        TryCount tryCount = new TryCount();

        while (gameState) {
            bridge.resetBridge();
            gameLoop(bridgeGame, tryCount);
            gameState = askRetry();
        }
    }

    private void gameLoop(BridgeGame bridgeGame, TryCount tryCount) {
        boolean gameOneState = true;

        while (gameOneState) {
            tryCount.addTryCount();
            gameOneState = tryOnce(bridgeGame);
            outputView.printMap(bridgeGame.getMap());
        }
    }

    private boolean tryOnce(BridgeGame bridgeGame) {
        return bridgeGame.move(inputView.readMoving());
    }

    private boolean askRetry() {
        try {
            return Reply.getReply(inputView.readGameCommand());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askRetry();
        }
    }
}
