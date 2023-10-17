package bridge;

import bridge.controller.Controller;
import bridge.domain.BridgeGameMap;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        BridgeGameMap bridgeGameMap = new BridgeGameMap();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeGameMap);

        Controller controller = new Controller(inputView,outputView,bridgeGame);
        controller.run();
    }
}
