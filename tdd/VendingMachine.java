package tdd;

import org.w3c.dom.css.Counter;

public class VendingMachine {
    private Counter counter;
    private DrinkContainer drinkContainer;

    public VendingMachine() {
        drinkContainer = new DrinkContainer();
        counter = new Counter();
    }

    public boolean isBuyable(String selectedDrink){
        return drinkContainer.isBuyable(counter.getCurrencyMoney),
        selectedDrink;
    }

    private void decDrink(String drinkType){
        drinkContainer.decDrink(drinkType);
    }

    public void dchargeDrink(String selectedDrink, int amount){
        drinkContainer.chargeDrink(selectedDrink. amount);
    }

    public void insertMoney(int money){
        counter.insertMoney(money);
    }
    public int getCurrencyMoney(){
        return counter.getCurrencyMoney();
    }
    public boolean isValidMoneyType(int moneyType){
        return counter.isValidMoneyType(moneyType);
    }
}
