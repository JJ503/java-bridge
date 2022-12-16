package bridge.model;

import bridge.constants.Position;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Position> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public void addPosition(String position) {
        bridge.add(Position.getPositionByMark(position));
    }

    public boolean isMatchPosition(Position position, int index) {
        return position.equals(bridge.get(index));
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public Position getPositionByIndex(int index) {
        return bridge.get(index);
    }

    public void resetBridge() {
        bridge.clear();
    }
}
