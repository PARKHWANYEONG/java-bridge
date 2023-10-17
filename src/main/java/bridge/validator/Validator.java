package bridge.validator;

public class Validator {
    public static void bridgeSize(int size) {
        if(!(3 <= size && size <= 20)) throw new NumberFormatException();
    }
    public static void moving(String move) {
        if (!(move.equals("U") | move.equals("D"))) throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. (위: U, 아래: D)를 입력해주세요");
    }

    public static void retryInput(String input) {
        if(!(input.equals("R") || input.equals("Q")))
            throw new IllegalArgumentException("\"[ERROR] 잘못된 입력입니다. (재시도: R, 종료: Q)를 입력해주세요\"");
    }
}
