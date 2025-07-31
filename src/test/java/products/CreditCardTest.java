package products;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreditCardTest {

    @Test
    public void testCreditCardDebtCalculation() {
        CreditCard card = new CreditCard("USD", 2000, "MasterCard Credit", 0.2);
        card.withdraw(2500);
        assertEquals(card.getProductBalance(), 0);
        assertEquals(card.getDebt(), 500 * 1.2);
    }

    @Test
    public void testCreditCardBalanceAfterDepositCalculation() {
        CreditCard card = new CreditCard("USD", 2000, "MasterCard Credit", 0.2);
        card.withdraw(2500);
        card.deposit(600);
        assertEquals(card.productBalance, 100);
    }

}