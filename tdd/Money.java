package tdd;


import org.h2.tools.Server;
import org.hibernate.dialect.Database;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import java.awt.*;
import java.net.Socket;
import java.nio.Buffer;

import static com.sun.tools.javac.resources.CompilerProperties.Notes.Note;
import static sun.net.ftp.FtpClient.defaultPort;

class Money {
    protected String currency;
    String currency(){
        return currency;
    }

    protected int amount;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    Expression plus(Money addend) {
        return new Sum(this, addend);
    }
//    abstract Money times(int multiplier);

    static Money dollar(int amount){
        return new Dollar(amount,"USD");
    }
    static Money franc(int amount){
        return new Franc(amount, "CHF");
    }


    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    Expression times(int multipler){
        return new Money(amount * multipler, currency);
    }


    public String toString() {
        return amount + " " + currency;
    }

    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

    /**
     public testCompleteTransaction(){
     Server writer = Server(defaultPort(), " abc");
     Socket reader = Socket("localhost",defaultPort());


     Assertions.assertTrue(reader.isClosed());
     Assertions.assertTrue(reader.contents());

     Socket reader = Socket("localhost", defaultPort());
     Buffer reply = reader.contents();

     Bank bank = new Bank();
     bank.addRate("USD", "GBP", STANDARD_RATE);
     bank.commission(STANDARD_COMISSION);
     Money result = bank.convert(new Note(100, "USD"), 'GBP');
     Assertions.assertEquals(new Note(100 / 2 * (1 - 0.015),"GBP"), result);

     Reducer reducer = new Reducer(new Polygon());

     }
     */

    public void setUp(){
        store = RecordStore.openRecordStore("testing",true);
    }
    public void tearDown(){
        RecordStore.deleteRecordStore("testing");
    }

    public void testStore(){
        int id = store.addRecord(new byte[]{5,6}, 0,2);
        assertEquals(2, store.getRecordSize(id));
        byte[] buffer = new byte[2];
        Assertions.assertEquals(5, buffer[0]);
        Assertions.assertEquals(6, buffer[1]);
    }

    public void testOrderLookup(){
        Database database = new MockDatabase();
        database.exceptQuery("select order_no from Order where cust_no is 123");
        database.returnResult(new String[] {"Order 2", "Order 3"});
    }

}
