package tdd;

//import org.assertj.core.api.Assertions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static sun.jvm.hotspot.HelloWorld.fib;

@RunWith(SpringRunner.class)
@SpringBootTest
public class multiplication {
    @Test
    public void testMultiplication(){
        Dollar five = Money.dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
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

    public void testFileSystemError(){
        FullFile foo = new FullFile("foo");
        try {
            saveAs(foo);
            fail();
        }catch (IOException e){

        }
    }

    public void testFileSystemError() {
        File foo = new File("foo") {
            public boolean createNewFile() throws IOException {
                throw new IOException();
            }
        };
        try {
            saveAs(foo);
            fail();
        } catch (IOException e) {
        }
    }
    public MyDate yesterday(){
        return new MyDate(this.days()-1);
    }

    public void testSum(){
        assertEquals(4,plus(3,1));
    }
    private int plus(int augend, int addend){
        return 4;
    }

    public void testSum(){
        assertEquals(4, plus(3, 1));
        assertEquals(7,plus(3,4));
        assertEquals(5, sum(5));
        assertEquals(5, sum(5, new int[] {5}));
        assertEquals(5, sum(new int[] {5}));
        assertEquals(12, sum(new int[] {5,7}));
    }

    private int plus(int augend, int addend){
        return augend + addend;
    }

    private int sum(int value, int[] values) {
        int sum = 0;
        for (int i = 0; i<values.length; i++)
            sum += values[i];
        return value;
    }

    public void testEmpty(){
        Rectangle empty = new Rectangle(0, 0, 0, 0);
        assertTrue(empty.isEmpty());
    }
    public void testWidth(){
        Rectangle empty = new Rectangle(0, 0, 0, 0);
        assertEquals(0,0, empty.getWidth(), 0.0);
    }

    public void testRate(){
        exchange.addRate("USD", "GBP", 2);
        int rate = exchange.findRate("USD","GBP");
        Assertions.assertEquals(2, rate);
    }

    public void testMissingRate(){
        try{
            exchange.findRate"USD", "GBP");
            fail();
        }catch (IllegalArgumentException expected){

        }
    }

    public boolean setReadOnly(){
        SecurityManager guard = System.getSecurityManager();
        if(guard != null){
            guard.canWrite(path);
        }guard.canWrite(path);
        return fileSystem.setReadOnly(this);
    }

    public static SecurityManager getSecurityManager(){
        return security == null ? new LaxSecurity() : security;
    }

    assertEqual(new MyDate("28.02"), new MyDate("1.3.02")yesterday());

    public void testSum(){
        assertEquals(4, plus(3,1));
        assertEquals(7, plus(3,4));
        assertEquals(5, sum(5));
        assertEquals(5, sum(5, new int[] {5}));
        assertEquals(12, sum(new int[] {5,7}));

    }
    private int plus(int augend, int addend){
        return augend + addend;
    }
    private int sum(int value, int[] values){
        int sum=0;
        for (int i=0; i<values.length; i++)
            sum += values[i];
        return value;
    }
    private Rectangle empty;

    public void testEmpty(){
        Rectangle empty = new Rectangle(0, 0, 0, 0);
        assertEquals(0.0, empty.getWidth(), 0.0);
    }

    public void setUp(){
        empty = new Rectangle(0,0,0,0)
    }
    public void testEmpty(){
        assertTrue(empty.isEmpty());
    }
    public void testWidth(){
        assertEquals(0.0, empty.getWidth(), 0.0);
    }
    public void testRate(){
        exchange.addRate("USD","GBP",2);
        int rate = exchange.findRate("USD","GBP");
        assertEquals(2, rate);
    }
    public void testMissingRate(){
        try{
            exchange.findRate("USD", "GBP");
            fail();
        }catch (IllegalArgumentException expected){

        }
    }
    void testSumPrinting() {
        Sum sum = new Sum(Money.dollar(5), Money.franc(7));
        assertEquals("5 USD + 7 CHF", sum.toString());
    }
    public String toString() {
        IndentingStream writer = new IndentingStream();
        toString(writer);
        return writer.contents();
    }
    void toString(IndentingWriter writer){
        writer.println("+");
        writer.indent();
        augend.toString(writer);
        writer.println();
        addend.toString(writer);
        writer.exdent();
    }

    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        tdd.Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = sum.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    public void testFibonacci(){
        int cases[][] = {{0,0},{1,1},{2,1},{3,2}};
        for (int i=0; i< cases.length; i++)
            assertEquals(cases[i][1], fib(cases[i][0]));
            assertEquals(0, fib(0));
            assertEquals(1,fib(1));
    }

    int fib(int n){
        if (n==0) return 0;
        if (n<=2) return 1;
        return fib(n-1) + fib(n-2);
    }



}
