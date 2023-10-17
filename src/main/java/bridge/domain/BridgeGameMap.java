package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameMap {

    private final String FORMAT = "[ %s ]\n";
    private final String DELIMITER = " | ";
    private final String EMPTY = " ";

    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();
    public void upper(String result) {
        upperBridge.add(result);
        lowerBridge.add(EMPTY);
    }
    public void lower(String result) {
        lowerBridge.add(result);
        upperBridge.add(EMPTY);
    }
    @Override
    public String toString() {
        return String.format(FORMAT,String.join(DELIMITER,upperBridge))
                + String.format(FORMAT,String.join(DELIMITER,lowerBridge));
    }
    public void reset() {
        upperBridge.clear();
        lowerBridge.clear();
    }
}
