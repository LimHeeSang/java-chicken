package service;

import domain.Category;
import domain.MenuDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PayMachineTest {

    @Test
    void 할인적용없이_테이블의_총결제금액_계산() {
        List<MenuDto> menus = createMenuDtos();
        int price = PayMachine.calculatePrice(menus);
        assertThat(price).isEqualTo(81000);
    }

    private List<MenuDto> createMenuDtos() {
        List<MenuDto> menus = new ArrayList<>();
        menus.add(new MenuDto("후라이드", Category.CHICKEN, 3, 16000));
        menus.add(new MenuDto("양념치킨", Category.CHICKEN, 2, 16000));
        menus.add(new MenuDto("콜라", Category.BEVERAGE, 1, 1000));
        return menus;
    }

    @Test
    void 치킨할인금액_계산() {
        List<MenuDto> menus = createChickenDiscountMenuDtos();
        int discount = PayMachine.calculateChickenDiscount(menus);
        assertThat(discount).isEqualTo(50000);
    }

    private List<MenuDto> createChickenDiscountMenuDtos() {
        List<MenuDto> menus = new ArrayList<>();
        menus.add(new MenuDto("후라이드", Category.CHICKEN, 35, 16000));
        menus.add(new MenuDto("양념치킨", Category.CHICKEN, 17, 16000));
        menus.add(new MenuDto("콜라", Category.BEVERAGE, 1, 1000));
        return menus;
    }
}
