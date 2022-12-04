package view;

import java.util.Arrays;

public enum FeatureType {

    ORDER(1), PAY(2), END(3);

    private static final String ERROR_INVALID_FEATURE_NUMBER = "기능 번호는 1, 2, 3중에서 가능합니다.";
    private final int number;

    FeatureType(int number) {
        this.number = number;
    }

    public static FeatureType of(int number) {
        return Arrays.stream(FeatureType.values())
                .filter(featureType -> featureType.isEqualNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_NUMBER));
    }

    private boolean isEqualNumber(int number) {
        return this.number == number;
    }

    public boolean isOrder() {
        return this == ORDER;
    }

    public boolean isPay() {
        return this == PAY;
    }

    public boolean isEnd() {
        return this == END;
    }
}
