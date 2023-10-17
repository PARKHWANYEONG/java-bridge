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
        bridgeGameResult();
    }
    private void bridgeGameResult() {
        outputView.printResult(bridgeGame);
    }

    private void bridgeGameStart() {
        bridgeGame.attempt();
        while (!bridgeGame.isSuccess() && !bridgeGame.isFail()) {
            String moving = inputView.readMoving();
            BridgeGameMap result = bridgeGame.move(moving);
             outputView.printMap(result);
        }
        if (bridgeGame.isFail()) {
            if(bridgeGame.retry(inputView.readGameCommand())){
                bridgeGameStart();
            }
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
