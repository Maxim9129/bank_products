package products;

import interfaces.Rechargeable;
import interfaces.Withdrawable;
import lombok.Getter;

@Getter
public class CreditCard extends BankProduct implements Rechargeable, Withdrawable {

    private double percent;
    private double debt;
    protected double limit;

    public CreditCard(String currency, double balance, String name, double percent) {
        super(currency, balance, name);
        this.percent = percent;
        this.limit = balance;
        this.debt = 0;
    }

    @Override
    public void deposit(double amount) {
        if (debt > 0) {
            double payment = Math.min(amount, debt);
            debt -= payment;
        }
        productBalance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= productBalance) {
            productBalance -= amount;
            if (productBalance < limit) {
                debt = limit - productBalance;
            }
        }
        else
            throw new IllegalStateException("Not enough money!");
    }

    public double getDebt() {
        return debt * (1 + percent);
    }

    public double getPercent() {
        return percent;
    }
}
