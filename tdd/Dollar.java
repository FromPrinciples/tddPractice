package tdd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Dollar extends Money{
    int amount;
    private String currency;
    public Dollar(int amount) {
        super(amount, currency);
    }

    String currency(){
        return currency;
    }

    Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    public boolean equals(Object object){
        Money dollar = (Money) object;
        return amount == dollar.amount;
    }

    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }




}
