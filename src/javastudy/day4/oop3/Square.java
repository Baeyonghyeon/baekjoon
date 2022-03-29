package javastudy.day4.oop3;

public class Square extends Shape {
    Point position;
    int width;

    public Square(int x, int y,int width){
        this.position = new Point(x,y);
        this.width = width;

    }

    public int getArea(){
        return width * width;
    }
}

class Shape{
    public static void main(String[] args) {
        Square s = new Square(1,1,20);
        System.out.println("넓이 : "+s.getArea());
    }
}

class Circle extends Shape{
    Point position;
    int radius;

    public Circle(int x, int y, int radius){
        this.position = new Point(x,y);
        this.radius = radius;
    }

    public int getArea(){
        return (int) (radius * radius * Math.PI);
    }
}

class Triangle extends Shape{

    Point position;
    int h;
    int width;

    public Triangle(int x, int y, int h, int width){
        this.position = new Point(x,y);
        this.h = h;
        this.width = width;
    }

    public int getArea(){
        return (width * h) / 2;
    }
}

class Rectangle extends Shape{
    Point posistion;
    int h;
    int width;

    public Rectangle(int x, int y, int h, int width){
        this.posistion = new Point(x,y);
        this.h = h;
        this.width = width;
    }

    public int getArea(){
        return width * h;
    }
}

class Point{
    int x;  //x좌표
    int y;  //y좌표

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
