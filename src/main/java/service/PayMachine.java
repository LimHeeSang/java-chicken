package service;

import domain.MenuDto;

import java.util.List;

public class PayMachine {

    private static final int CHICKEN_DISCOUNT_PRICE = 10000;
    private static final int CHICKEN_DISCOUNT_COUNT = 10;

    public static int calculatePrice(List<MenuDto> menus) {
        return menus.stream()
                .mapToInt(m -> m.getPrice() * m.getCount())
                .sum();
    }

    public static int calculateChickenDiscount(List<MenuDto> menus) {
        int count = menus.stream()
                .filter(m -> m.getCategory().isChicken())
                .mapToInt(MenuDto::getCount)
                .sum();
        return (count / CHICKEN_DISCOUNT_COUNT) * CHICKEN_DISCOUNT_PRICE;
    }

    public static int calculatePayTypeDiscount(List<MenuDto> menus) {
        return (int) (calculatePrice(menus) * 0.05);
    }
}
