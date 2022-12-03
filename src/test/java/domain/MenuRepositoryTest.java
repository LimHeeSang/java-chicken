package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    @Test
    void 메뉴번호로_메뉴찾기() {
        Menu menu = MenuRepository.findByNumber(1);
        assertThat(menu).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }

    @Test
    void 없는번호로_메뉴를찾으면_예외발생() {
        assertThatThrownBy(() -> new Menu(100, "후라이드", Category.CHICKEN, 16_000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 메뉴번호는 없습니다.");
    }
}