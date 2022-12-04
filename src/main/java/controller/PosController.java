package controller;

import service.PayType;
import service.PosService;
import view.FeatureType;
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

            if (feature.isOrder()) {
                featurePay();
            }
            if (feature.isPay()) {
                featureOrder();
            }
        } while (!feature.isEnd());
    }

    private void featureOrder() {
        OutputView.printTables(posService.getTableNumbers());
        int tableNumber = InputView.inputTableNumber();

        OutputView.printOrderMenus(posService.getMenus(tableNumber));

        PayType payType = InputView.inputPayNumber(tableNumber);
        int price = posService.pay(payType, tableNumber);

        OutputView.printOrderPrice(price);
    }

    private void featurePay() {
        OutputView.printTables(posService.getTableNumbers());
        int tableNumber = InputView.inputTableNumber();

        OutputView.printMenus(posService.getMenus());
        int menuNumber = InputView.inputMenuNumber();

        int menuCount = InputView.inputMenuCount();
        posService.createOrder(tableNumber, menuNumber, menuCount);
    }
}
