package products;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DepositTest {

    @Test(expectedExceptions = IllegalStateException.class)
    public void testDepositClose() {
        Deposit deposit = new Deposit("RUB", 5000, "Clever");
        deposit.deposit(1000);
        assertEquals(deposit.getProductBalance(), 6000);

        deposit.close("Clever");
        assertTrue(deposit.isClosed());

        deposit.deposit(2000);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testDepositCloseWrongName() {
        Deposit deposit = new Deposit("RUB", 5000, "Clever");

        deposit.close("Deposit");
    }
}