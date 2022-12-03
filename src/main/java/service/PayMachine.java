package service;

import domain.MenuDto;

import java.util.List;

public class PayMachine {

    public static int calculatePrice(List<MenuDto> menus) {
        return menus.stream()
                .mapToInt(m -> m.getPrice() * m.getCount())
                .sum();
    }
}
