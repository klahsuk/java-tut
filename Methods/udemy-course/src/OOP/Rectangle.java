package OOP;

public class Rectangle {

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.length = length < 0 ? 0 : length;
        this.width = width < 0 ? 0 : width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea(){
        return length * width;
    }

}
