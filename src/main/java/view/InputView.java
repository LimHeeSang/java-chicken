package view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_FEATURE_NUMBER_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_TABLE_NUMBER_MESSAGE = "## 주문할 테이블을 선택하세요.";
    private static final String INPUT_MENU_NUMBER_MESSAGE = "## 등록할 메뉴를 선택하세요.";
    private static final String INPUT_MENU_COUNT_MESSAGE = "## 메뉴의 수량을 입력하세요.";
    private static final String INPUT_PAY_NUMBER_MESSAGE = "## 신용 카드는 1번, 현금은 2번";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String TABLE_NUMBER_PAYMENT_MESSAGE = "## %d번 테이블의 결제를 진행합니다.\n";

    public static int inputFeatureNumber() {
        System.out.println(INPUT_FEATURE_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println(INPUT_TABLE_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println(INPUT_MENU_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println(INPUT_MENU_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputPayNumber(int tableNumber) {
        System.out.printf(TABLE_NUMBER_PAYMENT_MESSAGE, tableNumber);
        System.out.println(INPUT_PAY_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
