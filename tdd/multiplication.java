package tdd;

//import org.assertj.core.api.Assertions;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class multiplication {
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
    }

    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }

    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.dollar(1).currency());
    }

    public void testDifferentClassEqulity(){
        assertTrue(new Money(10, "CHF").equals(
                new Franc(10, "CHF")));
    }

    public void testSimpleAddition(){
//        Money sum = Money.dollar(5).plus(Money.dollar(5));
        Money five = Money.dollar(5);
        Expression sum = (Expression) five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");


        assertEquals(Money.dollar(10),sum);
        assertEquals(Money.dollar(10), reduced);
    }

    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(5);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.augend);
    }

    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }
    public void testArrayEquals(){
        assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
    }

    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD","USD"));
    }

    public void testMixedAddition(){
        Expression fiveBucks = (Expression) Money.dollar(5);
        Expression tenFrancs = (Expression) Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Money result = bank.reduce(
                fiveBucks.plus(tenFrancs),"USD");
        assertEquals(Money.dollar(10), result);
    }

    public void SumPlusMoney(){
        tdd.Expression fivebucks = Money.dollar(5);
        tdd.Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        tdd.Expression sum = new Sum(fivebucks, tenFrancs).plus(fivebucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15),result);
    }

    public void testSumTimew(){
        tdd.Expression fiveBucks = Money.dollar(5);
        tdd.Expression tenFrancs = Money.dollar(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    public void testPlusSameCurrencyReturnsMoney(){
        tdd.Expression sum = Money.dollar(1).plus(Money.dollar(1));
        assertTrue(sum instanceof Money);
    }

}
