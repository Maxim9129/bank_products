package products;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CardTest {

    @Test
    public void testCardDepositWithdraw() {
        Card card = new Card("RUB", 1000, "Дебетовая карта");
        card.deposit(500);
        assertEquals(card.getProductBalance(), 1500);

        card.withdraw(300);
        assertEquals(card.getProductBalance(), 1200);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testCardNotEnoughMoney() {
        Card card = new Card("RUB", 1000, "Mastercard");
        card.withdraw(1100);
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testCardWithIncorrectCurrency() {
        new Card("RUBB", 1000, "Mastercard");
        new Card("RR", 1000, "Mastercard");
    }

}