package bridge.service;

import bridge.constants.BridgeDraw;
import bridge.model.Bridge;
import bridge.model.Grades;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final Bridge userBridge;
    private final Grades grades;
    private boolean isSuccess;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.userBridge = new Bridge();
        this.grades = new Grades();
        this.isSuccess = false;
    }

    public boolean move(String position) {
        boolean moveState = moveEvent(position);
        isSuccess = checkBridgeState();
        System.out.println(isSuccess);
        return moveState && !isOverToMakeBridge();
    }

    private boolean moveEvent(String position) {
        userBridge.addPosition(position);
        int lastIndex = userBridge.getBridgeSize() - 1;
        boolean grade = bridge.isMatchPosition(userBridge.getPositionByIndex(lastIndex), lastIndex);
        grades.addGrade(grade);
        return grade;
    }


    public String getMap() {
        return BridgeDraw.getBridgeDraw(userBridge.getBridge(), grades.getGrades());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userBridge.resetBridge();
        grades.resetGrades();
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    private boolean checkBridgeState() {
        if (isOverToMakeBridge()) {
            return isSuccess();
        }

        return false;
    }

    private boolean isOverToMakeBridge() {
        return bridge.isSameSize(userBridge.getBridgeSize());
    }

    private boolean isSuccess() {
        return bridge.isAllCorrect(userBridge.getBridge());
    }
}
