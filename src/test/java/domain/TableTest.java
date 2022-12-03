package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TableTest {

    @CsvSource(value = {"1,후라이드,16000", "2,양념치킨,16000", "3,반반치킨,16000"})
    @ParameterizedTest
    void 메뉴와_메뉴수량을_저장(int number, String name, int price) {
        Menu menu = new Menu(number, name, Category.CHICKEN, price);
        Table table = new Table(1);

        table.saveMenu(menu, 3);

        List<MenuDto> menus = table.getMenus();
        assertThat(menus.get(0).getName()).isEqualTo(name);
        assertThat(menus.get(0).getCount()).isEqualTo(3);
        assertThat(menus.get(0).getPrice()).isEqualTo(price);
    }
}