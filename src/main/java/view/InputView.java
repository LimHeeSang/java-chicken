package view;

import service.PayType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_FEATURE_NUMBER_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_TABLE_NUMBER_MESSAGE = "## 주문할 테이블을 선택하세요.";
    private static final String INPUT_MENU_NUMBER_MESSAGE = "## 등록할 메뉴를 선택하세요.";
    private static final String INPUT_MENU_COUNT_MESSAGE = "## 메뉴의 수량을 입력하세요.";
    private static final String INPUT_PAY_NUMBER_MESSAGE = "## 신용 카드는 1번, 현금은 2번";
    private static final String TABLE_NUMBER_PAYMENT_MESSAGE = "## %d번 테이블의 결제를 진행합니다.\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static FeatureType inputFeatureNumber() {
        System.out.println(INPUT_FEATURE_NUMBER_MESSAGE);
        try {
            return FeatureType.of(scanner.nextInt());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("기능 번호는 숫자만 가능합니다.");
        }
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

    public static PayType inputPayNumber(int tableNumber) {
        System.out.printf(TABLE_NUMBER_PAYMENT_MESSAGE, tableNumber);
        System.out.println(INPUT_PAY_NUMBER_MESSAGE);
        try {
            return PayType.of(scanner.nextInt());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("결제 번호는 숫자만 가능합니다.");
        }
    }
}
