package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Table {

    private static final int DEFAULT_COUNT = 0;
    private static final String ERROR_INVALID_MAXIMUM_MENU_COUNT = "한 메뉴의 최대 수량을 99개가 넘어갈 수 없습니다.";
    private static final int MAXIMUM_MENU_COUNT = 99;

    private final int number;
    private final Map<Menu, Integer> menus;

    public Table(final int number) {
        this.number = number;
        menus = new HashMap<>();
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void saveMenu(Menu menu, int count) {
        count += menus.getOrDefault(menu, DEFAULT_COUNT);
        validateCount(count);
        menus.put(menu, count);
    }

    private void validateCount(int count) {
        if (count > MAXIMUM_MENU_COUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_MAXIMUM_MENU_COUNT);
        }
    }

    public List<OrderMenuDto> getMenus() {
        return menus.entrySet().stream()
                .map(e -> e.getKey().toDto(e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
