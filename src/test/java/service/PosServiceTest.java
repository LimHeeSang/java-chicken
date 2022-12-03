package service;

import domain.MenuDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PosServiceTest {

    @Test
    void 주문등록_서비스() {
        PosService posService = new PosService();
        posService.createOrder(1, 1, 5);
        posService.createOrder(1, 1, 2);
        List<MenuDto> menus = posService.getMenus(1);
        assertThat(menus.get(0).getCount()).isEqualTo(7);
        assertThat(menus.get(0).getName()).isEqualTo("후라이드");
    }
}