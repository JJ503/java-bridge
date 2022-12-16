package bridge;

import bridge.constants.Position;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bridge.add(getRandomPosition());
        }

        return bridge;
    }

    private String getRandomPosition() {
        return Position.getPositionByNumber(bridgeNumberGenerator.generate()).getMark();
    }
}
