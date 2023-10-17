package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.BridgeGameMap;

import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final BridgeGameMap bridgeGameMap;

    private int attempt = 0;
    private int index = 0;
    private List<String> bridge;
    private boolean fail = false;
    private boolean success = false;

    public BridgeGame(BridgeMaker bridgeMaker , BridgeGameMap bridgeGameMap) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeGameMap = bridgeGameMap;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGameMap move(String moving) {
        String result = "O";
        if (!bridge.get(index).equals(moving)) {
            result = "X";
            fail = true;
        }
        if(++index == bridge.size() && fail == false) success = true;
        if (moving.equals("U")) bridgeGameMap.upper(result);
        if (moving.equals("D")) bridgeGameMap.lower(result);
        return bridgeGameMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals("R")) {
            clear();
            return true;
        }
        return false;
    }

    private void clear() {
        bridgeGameMap.reset();
        index = 0;
        fail = false;
        success = false;
    }

    public void initBridge(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridge.toString() = " + bridge.toString());
    }
    public List<String> getBridge() {
        return bridge;
    }

    public boolean isFail() {
        return this.fail;
    }

    void testBridge(List<String> list) {
        this.bridge = list;
    }

    public BridgeGameMap getBridgeGameMap() {
        return bridgeGameMap;
    }

    public boolean isSuccess() {
        return success;
    }

    public void counting() {

    }
    public void attempt() {
        attempt++;
    }

    public int getAttempt() {
        return attempt;
    }
}
