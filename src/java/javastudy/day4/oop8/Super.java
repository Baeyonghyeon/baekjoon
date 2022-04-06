package java.javastudy.day4.oop8;

public class Super {
    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 10;
        System.out.println("speed = " + car.getSpeed());
    }
}

class Vehicle{
    int speed;
    public int getSpeed(){
        return speed;   //this.speed
    }
}

class Car extends Vehicle{
//    int speed;
//
//    // 오버라이드를 하게 되면 중복이 되므로 옳은 방향은 아니다
//    @Override
//    public int getSpeed() {
//        return this.speed;
//    }
}