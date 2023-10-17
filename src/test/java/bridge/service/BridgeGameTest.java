package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;
    @BeforeEach
    void beforeEach() {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        bridgeGame = new BridgeGame(bridgeMaker);
    }
    @Test
    void 다리_생성() {
        bridgeGame.initBridge(3);
        List<String> bridge = bridgeGame.getBridge();
        assertThat(bridge.size()).isEqualTo(3);
        assertTrue(bridge.stream().allMatch(s-> s.equals("U") | s.equals("D")));
    }


}