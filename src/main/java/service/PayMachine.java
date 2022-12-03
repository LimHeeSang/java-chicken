package service;

import domain.OrderMenuDto;

import java.util.List;

public class PayMachine {

    private static final int CHICKEN_DISCOUNT_PRICE = 10000;
    private static final int CHICKEN_DISCOUNT_COUNT = 10;

    public static int calculatePrice(PayType payType, List<OrderMenuDto> menus) {
        int price = calculatePrice(menus);
        price -= calculateChickenDiscount(menus);
        return payType.calculate(price);
    }

    public static int calculatePrice(List<OrderMenuDto> menus) {
        return menus.stream()
                .mapToInt(m -> m.getPrice() * m.getCount())
                .sum();
    }

    public static int calculateChickenDiscount(List<OrderMenuDto> menus) {
        int count = menus.stream()
                .filter(m -> m.getCategory().isChicken())
                .mapToInt(OrderMenuDto::getCount)
                .sum();
        return (count / CHICKEN_DISCOUNT_COUNT) * CHICKEN_DISCOUNT_PRICE;
    }
}
