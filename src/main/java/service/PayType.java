package service;

import java.util.Arrays;
import java.util.function.Function;

public enum PayType {

    CASH(2, price -> price - (int) (price * Constants.CASH_DISCOUNT_PERCENT)),
    CARD(1, price -> price);

    private static final String ERROR_INVALID_INPUT_PAY_NUMBER = "결제 번호는 1 or 2만 가능합니다.";
    private static class Constants {
        private static final double CASH_DISCOUNT_PERCENT = 0.05;
    }

    private final int number;
    private final Function<Integer, Integer> calculatePrice;

    PayType(int number, Function<Integer, Integer> calculatePrice) {
        this.number = number;
        this.calculatePrice = calculatePrice;
    }

    public static PayType of(int number) {
        return Arrays.stream(PayType.values())
                .filter(payType -> payType.isEqualNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_INPUT_PAY_NUMBER));
    }

    public boolean isEqualNumber(int number) {
        return this.number == number;
    }

    public int calculate(int price) {
        return calculatePrice.apply(price);
    }
}
