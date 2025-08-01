package products;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreditCardTest {

    @Test
    public void testCreditCardDebtCalculation() {
        CreditCard card = new CreditCard("USD", 15000, "MasterCard Credit", 0.2);
        card.withdraw(2500);
        assertEquals(card.getProductBalance(), 12500);
        assertEquals(card.getDebt(), 2500 * 1.2);
    }

    @Test
    public void testCreditCardBalanceAfterDepositCalculation() {
        CreditCard card = new CreditCard("USD", 12000, "MasterCard Credit", 0.2);
        card.withdraw(2500);
        card.deposit(600);
        assertEquals(card.getProductBalance(), 10100);
        card.deposit(3400);
        assertEquals(card.getProductBalance(), 13500);
        assertEquals(card.getDebt(), 0);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testCreditCardNotEnoughMoney() {
        Card card = new Card("RUB", 1000, "Mastercard");
        card.withdraw(1100);
    }

}