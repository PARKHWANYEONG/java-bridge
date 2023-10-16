package bridge.controller;


import bridge.OutputView;

public class Controller {

    private final OutputView outputView;
    public void run() {
        bridgeGameStart();

    }
    private void bridgeGameStart() {
        outputView.gameStart();

    }

    public Controller(OutputView outputView) {
        this.outputView = outputView;
    }
}
