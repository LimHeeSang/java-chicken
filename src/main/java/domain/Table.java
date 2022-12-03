package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Table {

    private final int number;
    private final Map<Menu, Integer> menus;

    public Table(final int number) {
        this.number = number;
        menus = new HashMap<>();
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return number == table.number;
    }

    public void saveMenu(Menu menu, int count) {
        menus.put(menu, count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public List<MenuDto> getMenus() {
        return menus.entrySet().stream()
                .map(e -> e.getKey().toDto(e.getValue()))
                .collect(Collectors.toList());
    }
}
