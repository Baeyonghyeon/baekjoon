package java.javastudy.day4.oop12;

public class st {
    public static void main(String[] args) {
        Point position = new Point(0,0);
        Shape s1 = new Square(position, 10);    // 정사각형
        //Shape s2 = new Triangle(position, 10, 20);  // 삼각형
        //Shape s3 = new Rectangle(position, 10, 20); // 직사각형

        s1.printShape();
        //printShape(s2);
        //printShape(s3);

    }
}

abstract class Shape {
    private Point position;

    public Shape(Point position) {
        this.position = position;
    }

    public Point getPosition() {    // 구현된 메서드
        return position;
    }

    public abstract int getArea();  // 추상 메서드

    public abstract void printShape();
}

class Square extends Shape {
    final int width;

    public Square(Point position, int width) {
        super(position);
        this.width = width;
    }

    @Override
    public int getArea() {
        return width * width;
    }

    @Override
    public void printShape() {
        System.out.println(getArea());
    }

    public int getWidth() {
        return width;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}