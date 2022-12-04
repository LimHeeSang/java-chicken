package controller;

import service.PosService;
import view.InputView;
import view.OutputView;

public class PayFeature implements Feature {

    @Override
    public void operate(PosService posService) {
        OutputView.printTables(posService.getTableNumbers());
        int tableNumber = InputView.inputTableNumber();

        OutputView.printMenus(posService.getMenus());
        int menuNumber = InputView.inputMenuNumber();

        int menuCount = InputView.inputMenuCount();
        posService.createOrder(tableNumber, menuNumber, menuCount);
    }
}
