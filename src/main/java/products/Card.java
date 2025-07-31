package products;

import interfaces.Rechargeable;
import interfaces.Withdrawable;

public class Card extends BankProduct implements Rechargeable, Withdrawable {

    public Card(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void deposit(double amount) {
        productBalance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= productBalance)
            productBalance -= amount;
        else
            throw new IllegalStateException("Not enough money!");
    }

}
