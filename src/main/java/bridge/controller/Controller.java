package bridge.controller;


import bridge.BridgeMaker;
import bridge.domain.BridgeGameMap;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    public void run() {
        bridgeGameInit();
        bridgeGameStart();
    }

    private void bridgeGameStart() {
        while (!bridgeGame.isFinishing()) {
            String moving = inputView.readMoving();
            BridgeGameMap result = bridgeGame.move(moving);
            outputView.printMap(result);
        }

    }
    private void bridgeGameInit() {
        outputView.gameStart();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.initBridge(bridgeSize);
    }

    public Controller(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }
}
