package tdd;

public class MyDate {
    public MyDate yesterday(){
        return new MyDate(this.days()-1);
    }
}
