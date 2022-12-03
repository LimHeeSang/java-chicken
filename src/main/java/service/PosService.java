package service;

import domain.Menu;
import domain.MenuDto;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class PosService {


    public void createOrder(int tableNumber, int menuNumber, int menuCount) {
        Table table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        table.saveMenu(menu, menuCount);
    }

    public List<MenuDto> getMenus(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        return table.getMenus();
    }

    public int pay(PayType payType, int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        return PayMachine.calculatePrice(payType, table.getMenus());
    }
}
