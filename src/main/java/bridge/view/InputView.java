package bridge.view;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.\n");
        int size;
        try {
             size = Integer.parseInt(Console.readLine());
            Validator.bridgeSize(size);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 3부터 20 사이의 정수를 입력해 주세요.");
            return readBridgeSize();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = "";
        try {
            moving = Console.readLine();
            Validator.moving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = "";
        try {
             input = Console.readLine();
            Validator.retryInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return input;
    }
}
