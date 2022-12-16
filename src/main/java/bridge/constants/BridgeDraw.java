package bridge.constants;

import java.util.ArrayList;
import java.util.List;

public enum BridgeDraw {
    START_BRIDGE("["),
    END_BRIDGE("]"),
    CORRECT_BRIDGE(" O "),
    WRONG_BRIDGE(" X "),
    BLANK_BRIDGE("   "),
    SPLIT_BRIDGE("|");

    private final String element;

    BridgeDraw(String element) {
        this.element = element;
    }

    public static String getBridgeDraw(List<Position> positions, List<Boolean> grades) {
        StringBuilder bridgeMaps = new StringBuilder();

        bridgeMaps.append(initStringBuilder(getMapUpperBridge(positions, grades)));
        bridgeMaps.append(System.lineSeparator());
        bridgeMaps.append(initStringBuilder(getLowerElementByGrade(positions, grades)));

        return bridgeMaps.toString();
    }

    private static String initStringBuilder(List<String> bridgeDraws) {
        StringBuilder bridgeMap = new StringBuilder();

        bridgeMap.append(START_BRIDGE);
        bridgeMap.append(String.join(SPLIT_BRIDGE.element, bridgeDraws));
        bridgeMap.append(END_BRIDGE);

        return bridgeMap.toString();
    }

    private static List<String> getMapUpperBridge(List<Position> positions, List<Boolean> grades) {
        List<String> bridgeDraws = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            bridgeDraws.add(getUpperElementByGrade(positions.get(i), grades.get(i)).element);
        }

        return bridgeDraws;
    }

    private static List<String> getLowerElementByGrade(List<Position> positions, List<Boolean> grades) {
        List<String> bridgeDraws = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            bridgeDraws.add(getUpperElementByGrade(positions.get(i), grades.get(i)).element);
        }

        return bridgeDraws;
    }

    private static BridgeDraw getUpperElementByGrade(Position position, Boolean grade) {
        if (position.equals(Position.UP) && grade) {
            return CORRECT_BRIDGE;
        }
        if (position.equals(Position.UP) && !grade) {
            return WRONG_BRIDGE;
        }

        return BLANK_BRIDGE;
    }

    private static BridgeDraw getLowerElementByGrade(Position position, Boolean grade) {
        if (position.equals(Position.DOWN) && grade) {
            return CORRECT_BRIDGE;
        }
        if (position.equals(Position.DOWN) && !grade) {
            return WRONG_BRIDGE;
        }

        return BLANK_BRIDGE;
    }
}
