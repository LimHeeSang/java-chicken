package controller;

import service.PayType;
import service.PosService;
import view.InputView;
import view.OutputView;

public class PosController {

    private static final int ORDER_FEATURE_NUMBER = 1;
    private static final int PAY_FEATURE_NUMBER = 2;
    private static final int END_FEATURE_NUMBER = 3;
    private final PosService posService;

    public PosController(PosService posService) {
        this.posService = posService;
    }

    public void run() {
        int feature;
        do {
            OutputView.printFeatures();
            feature = InputView.inputFeatureNumber();

            if (feature == ORDER_FEATURE_NUMBER) {
                featurePay();
            }
            if (feature == PAY_FEATURE_NUMBER) {
                featureOrder();
            }
        } while (feature != END_FEATURE_NUMBER);
    }

    private void featureOrder() {
        OutputView.printTables(posService.getTableNumbers());
        int tableNumber = InputView.inputTableNumber();

        OutputView.printOrderMenus(posService.getMenus(tableNumber));

        int payNumber = InputView.inputPayNumber(tableNumber);
        int price = posService.pay(PayType.of(payNumber), tableNumber);

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
