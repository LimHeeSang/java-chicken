package view;

import domain.MenuDto;
import domain.OrderMenuDto;

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
        printBlank();
    }

    private static void printBlank() {
        System.out.println();
    }

    public static void printTables(final List<Integer> tableNumbers) {
        System.out.println("## 테이블 목록");
        final int size = tableNumbers.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tableNumbers);
        printLine(BOTTOM_LINE, size);
        printBlank();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        printBlank();
    }

    private static void printTableNumbers(final List<Integer> tableNumbers) {
        for (final int tableNumber : tableNumbers) {
            System.out.printf(TABLE_FORMAT, tableNumber);
        }
        printBlank();
    }

    public static void printMenus(final List<MenuDto> menus) {
        printBlank();
        for (final MenuDto menu : menus) {
            String menuInfo = menu.getCategory() + " " +
                    menu.getNumber() + " - " +
                    menu.getName() + " : " +
                    menu.getPrice() + "원";
            System.out.println(menuInfo);
        }
        printBlank();
    }

    public static void printOrderMenus(List<OrderMenuDto> menus) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (OrderMenuDto menu : menus) {
            String menuInfo = menu.getName() + " " +
                    menu.getCount() + " " +
                    menu.getPrice();
            System.out.println(menuInfo);
        }
        printBlank();
    }

    public static void printOrderPrice(int price) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%d원\n", price);
        printBlank();
    }
}
