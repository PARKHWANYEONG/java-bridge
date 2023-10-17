package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.BridgeGameMap;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final BridgeGameMap bridgeGameMap;

    private int count = 0;
    private int index = 0;
    private List<String> bridge;
    private boolean finish = false;

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
            finish = true;
        }
        index++;
        if (moving.equals("U")) bridgeGameMap.upper(result);
        if (moving.equals("D")) bridgeGameMap.lower(result);
        return bridgeGameMap;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
    public void initBridge(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
    public List<String> getBridge() {
        return bridge;
    }

    public boolean isFinishing() {
        return this.finish || bridge.size() < index;
    }
}
