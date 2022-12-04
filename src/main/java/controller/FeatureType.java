package controller;

import service.PosService;

import java.util.Arrays;

public enum FeatureType {

    ORDER(1, new OrderFeature()),
    PAY(2, new PayFeature()),
    END(3, new EndFeature());

    private static final String ERROR_INVALID_FEATURE_NUMBER = "기능 번호는 1, 2, 3중에서 가능합니다.";
    private final int number;
    private final Feature feature;

    FeatureType(int number, Feature feature) {
        this.number = number;
        this.feature = feature;
    }

    public static FeatureType of(int number) {
        return Arrays.stream(FeatureType.values())
                .filter(featureType -> featureType.isEqualNumber(number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_FEATURE_NUMBER));
    }

    public void operate(PosService posService) {
        feature.operate(posService);
    }

    private boolean isEqualNumber(int number) {
        return this.number == number;
    }

    public boolean isEnd() {
        return this == END;
    }
}
