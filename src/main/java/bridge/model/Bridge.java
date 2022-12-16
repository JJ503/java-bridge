package bridge.model;

import bridge.constants.Position;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Position> bridge = new ArrayList<>();

    public Bridge(List<String> bridge) {
        for (String position : bridge) {
            this.bridge.add(Position.getPositionByMark(position));
        }
    }
}
