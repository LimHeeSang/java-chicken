package view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_FEATURE_NUMBER_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_TABLE_NUMBER_MESSAGE = "## 주문할 테이블을 선택하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFeatureNumber() {
        System.out.println(INPUT_FEATURE_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println(INPUT_TABLE_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
