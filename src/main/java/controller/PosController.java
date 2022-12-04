package controller;

import service.PosService;
import view.InputView;
import view.OutputView;

public class PosController {

    private final PosService posService;

    public PosController(PosService posService) {
        this.posService = posService;
    }

    public void run() {
        FeatureType feature;
        do {
            OutputView.printFeatures();
            feature = InputView.inputFeatureNumber();

            feature.operate(posService);
        } while (!feature.isEnd());
    }
}
