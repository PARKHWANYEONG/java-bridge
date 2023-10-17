package bridge.validator;

public class Validator {
    public static void bridgeSize(int size) {
        if(!(3 <= size && size <= 20)) throw new NumberFormatException("[ERROR] 3부터 20 사이의 정수를 입력해 주세요.");
    }
    public static void moving(String move) {
        if (!(move.equals("U") | move.equals("D"))) throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 위: U, 아래: D를 입력해주세요");
    }
}
