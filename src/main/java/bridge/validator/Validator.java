package bridge.validator;

public class Validator {
    public static void bridgeSize(int size) {
        if(!(3 <= size && size <= 20)) throw new NumberFormatException();
    }
}
