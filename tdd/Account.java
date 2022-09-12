package tdd;

public class Account {
    Holding holdings [];
    Money balance() {
        Money sum = Money.zero();
        for ( int i=0; i < holdings.length; i++) {
            Expression sum = sum.plus(holdings[i].balance());

        }
        return sum;
    }
}
