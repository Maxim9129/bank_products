package products;

import interfaces.Closable;
import interfaces.Rechargeable;
import products.BankProduct;

import java.util.Objects;

public class Deposit extends BankProduct implements Rechargeable, Closable {

    private boolean isClosed = false;

    public Deposit(String currency, long balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void deposit(double amount) {
        if (isClosed) {
            throw  new IllegalStateException("Вклад закрыт!");
        }
        productBalance += amount;
    }

    @Override
    public void close(String productName){
        if (Objects.equals(this.productName, productName)) {
            isClosed = true;
            System.out.println("Deposit " + productName + " is closed!");
        }
        else
            throw  new IllegalStateException("Указанного вклада не существует");
    }

    public boolean isClosed() {
        return isClosed;
    }
}
