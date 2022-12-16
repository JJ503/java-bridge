package bridge.service;

import bridge.model.Bridge;
import bridge.model.Grades;
import bridge.model.TryCount;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Bridge userBridge;
    private final Grades grades;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.userBridge = new Bridge();
        this.grades = new Grades();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String position) {
        userBridge.addPosition(position);
        int lastIndex = userBridge.getBridgeSize() - 1;
        boolean grade = bridge.isMatchPosition(userBridge.getPositionByIndex(lastIndex), lastIndex);
        grades.addGrade(grade);
        return grade;
    }

    public void getMap() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
