package tdd;

public class Rectangle {
    public int area(){
        int width = this.right() - this.left();
        int height = this.bottom() - this.top();
        int area = width * height;
    }
}
