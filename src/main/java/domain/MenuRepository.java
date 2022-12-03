package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRepository {

    private static final String ERROR_NOT_EXIST_MENU = "해당 메뉴번호는 없습니다.";
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static Menu findByNumber(int number) {
        return menus().stream()
                .filter(menu -> menu.isSameNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_MENU));
    }

    public static List<MenuDto> getMenus() {
        return menus().stream()
                .map(Menu::toMenuDto)
                .collect(Collectors.toList());
    }
}
