package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGameMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;
    @BeforeEach
    void beforeEach() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        BridgeGameMap bridgeGameMap = new BridgeGameMap();
        bridgeGame = new BridgeGame(bridgeMaker,bridgeGameMap);
    }
    @Test
    void 다리_생성_테스트() {
        bridgeGame.initBridge(3);
        List<String> bridge = bridgeGame.getBridge();
        assertThat(bridge.size()).isEqualTo(3);
        assertTrue(bridge.stream().allMatch(s-> s.equals("U") | s.equals("D")));
    }

    @Test
    void 이동할_칸_입력받기() {
        bridgeGame.testBridge(Arrays.asList("U","D","D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        BridgeGameMap move = bridgeGame.move("U");
        System.out.println(move);
        assertThat(move.toString()).isEqualTo("[ O |   | X ]\n"+
                "[   | O |   ]\n");

    }

}