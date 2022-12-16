package bridge.model;

import bridge.constants.Position;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Position> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>();
        for (String position : bridge) {
            addPosition(position);
        }
    }

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public void addPosition(String position) {
        bridge.add(Position.getPositionByMark(position));
    }
}
