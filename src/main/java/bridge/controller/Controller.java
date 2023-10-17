package bridge.controller;


import bridge.BridgeMaker;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    public void run() {
        bridgeGameStart();

    }
    private void bridgeGameStart() {
        outputView.gameStart();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.initBridge(bridgeSize);
    }


    public Controller(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = new BridgeGame(bridgeMaker);
    }
}
