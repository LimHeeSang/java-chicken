package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRepositoryTest {

    @Test
    void 메뉴번호로_메뉴찾기() {
        Menu menu = MenuRepository.findByNumber(1);
        assertThat(menu).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }
}