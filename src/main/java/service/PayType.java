package service;

import java.util.function.Function;

public enum PayType {

    CASH(price -> price - (int) (price * Constants.CASH_DISCOUNT_PERCENT)),
    CARD(price -> price);

    private static class Constants {
        private static final double CASH_DISCOUNT_PERCENT = 0.05;
    }

    private final Function<Integer, Integer> calculatePrice;

    PayType(Function<Integer, Integer> calculatePrice) {
        this.calculatePrice = calculatePrice;
    }

    public int calculate(int price) {
        return calculatePrice.apply(price);
    }
}
