package javastudy.day4.oop11;

public class ProtectedModifier {
    public static void main(String[] args) {
        Car car = new Car();
        car.setColorAndSpeed("red", 20);
        System.out.println("color: "+ car.getColor());
        System.out.println("speed: "+ car.getSpeed());
        car.color = "blue";
        System.out.println(car.getColor());
    }
}

/**
 * private = 같은 클래스만 접근 가능
 * default = 같은 패키지 접근가능
 * protected = 같은 패키지 & 자식 클래스 접근 가능
 * public = 제한없이 접근 가능
 */


class Vehicle{
    private int speed;      //자식 접근 불가
    String color; //자식 접그 가능

    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public String getColor(){
        return color;
    }
}

class Car extends Vehicle{
    public void setColorAndSpeed(String color, int speed){
        this.color = color; // super.color = color;
        super.setSpeed(speed);
    }
}
