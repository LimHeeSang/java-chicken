package controller;

import service.PayType;
import service.PosService;
import view.InputView;
import view.OutputView;

public class PayFeature implements Feature {

    @Override
    public void operate(PosService posService) {
        OutputView.printTables(posService.getTableNumbers());
        int tableNumber = InputView.inputTableNumber();

        OutputView.printOrderMenus(posService.getMenus(tableNumber));

        PayType payType = InputView.inputPayNumber(tableNumber);
        int price = posService.pay(payType, tableNumber);

        OutputView.printOrderPrice(price);
    }
}
