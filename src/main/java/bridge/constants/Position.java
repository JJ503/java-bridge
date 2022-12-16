package bridge.constants;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Position {
    DOWN("D", 0),
    UP("U", 1);

    private static final Map<String, Position> POSITION_BY_MARK = Stream.of(values())
            .collect(Collectors.toMap(Position::getMark, Function.identity()));
    private static final Map<Integer, Position> POSITION_BY_NUMBER = Stream.of(values())
            .collect(Collectors.toMap(Position::getMatchNumber, Function.identity()));

    private final String mark;
    private final int randomNumber;

    Position(String mark, int randomNumber) {
        this.mark = mark;
        this.randomNumber = randomNumber;
    }

    private String getMark() {
        return mark;
    }

    private int getMatchNumber() {
        return randomNumber;
    }

    public Position getPositionByMark(String mark) {
        return POSITION_BY_MARK.get(mark);
    }

    public Position getPositionByNumber(int number) {
        return POSITION_BY_NUMBER.get(number);
    }
}
