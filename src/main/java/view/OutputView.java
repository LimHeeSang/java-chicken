package view;

import domain.Menu;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printFeatures() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println( "3 - 프로그램 종료");
    }

    public static void printTables(final List<Integer> tableNumbers) {
        System.out.println("## 테이블 목록");
        final int size = tableNumbers.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tableNumbers);
        printLine(BOTTOM_LINE, size);
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Integer> tableNumbers) {
        for (final int tableNumber : tableNumbers) {
            System.out.printf(TABLE_FORMAT, tableNumber);
        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

}
