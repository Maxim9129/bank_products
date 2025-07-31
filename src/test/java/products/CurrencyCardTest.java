package products;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CurrencyCardTest {

    @Test
    public void testCurrencyCard() {
        CurrencyCard card = new CurrencyCard("EUR", 2000, "MasterCard Travel");
        card.withdraw(200);
        assertEquals(card.productBalance, 1800);
    }

}