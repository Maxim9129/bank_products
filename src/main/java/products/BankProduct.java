package products;

import lombok.Getter;

@Getter
public abstract class BankProduct {

    protected String productCurrency;
    protected double productBalance;
    protected String productName;

    public BankProduct(String currency, double balance, String name) {
        if (currency.length() != 3) {
            throw new IllegalStateException("Exception: currency is not 3 symbols!");
        }
        else
            this.productCurrency = currency;
        this.productBalance = balance;
        this.productName = name;
    }
}
