package service;

import domain.MenuDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PosServiceTest {

    private PosService posService;

    @BeforeEach
    void setUp() {
        posService = new PosService();
    }

    @Test
    void 주문등록_서비스() {
        posService.createOrder(1, 1, 5);
        posService.createOrder(1, 1, 2);
        List<MenuDto> menus = posService.getMenus(1);

        assertThat(menus.get(0).getCount()).isEqualTo(7);
        assertThat(menus.get(0).getName()).isEqualTo("후라이드");
    }

    @Test
    void 결제_서비스() {
        posService.createOrder(1, 1, 1);
        posService.createOrder(1, 21, 1);

        int price = posService.pay(PayType.CARD, 1);
        assertThat(price).isEqualTo(17000);
    }
}