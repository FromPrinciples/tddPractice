package tdd;



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
}
