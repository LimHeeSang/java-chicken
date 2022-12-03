package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TableTest {

    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table(1);
    }

    @CsvSource(value = {"1,후라이드,16000", "2,양념치킨,16000", "3,반반치킨,16000"})
    @ParameterizedTest
    void 메뉴와_메뉴수량을_저장(int number, String name, int price) {
        Menu menu = new Menu(number, name, Category.CHICKEN, price);
        table.saveMenu(menu, 3);

        List<OrderMenuDto> menus = table.getMenus();
        assertThat(menus.get(0).getName()).isEqualTo(name);
        assertThat(menus.get(0).getCount()).isEqualTo(3);
        assertThat(menus.get(0).getPrice()).isEqualTo(price);
    }

    @Test
    void 동일메뉴_여러번저장시_메뉴개수_테스트() {
        Menu firstMenu = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        Menu secondMenu = new Menu(1, "후라이드", Category.CHICKEN, 16000);

        table.saveMenu(firstMenu, 10);
        table.saveMenu(secondMenu, 4);

        List<OrderMenuDto> menus = table.getMenus();
        assertThat(menus.get(0).getCount()).isEqualTo(14);
    }

    @Test
    void 한메뉴의_수량이_99가넘어가면_예외발생() {
        Menu firstMenu = new Menu(1, "후라이드", Category.CHICKEN, 16000);
        Menu secondMenu = new Menu(1, "후라이드", Category.CHICKEN, 16000);

        table.saveMenu(firstMenu, 99);

        assertThatThrownBy(() -> table.saveMenu(secondMenu, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한 메뉴의 최대 수량을 99개가 넘어갈 수 없습니다.");
    }
}