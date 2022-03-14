package javaStudy.day4.oop7;

public class Super {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.speed = 20;
        Car car = new Car();
        car.speed = 10;
        System.out.println("speed = " + car.getSpeed());
        System.out.println("vehicleSpeed = " + car.getVehicleSpeed());
    }
}

class Vehicle {
    int speed;
    int getSpeed(){
        return speed;   //this.speed
    }
}

class Car extends Vehicle {
    int speed;
    int getVehicleSpeed(){
        //메소드인 경우 재정의 하면 되지만 인스턴스 변수인 경우는 this, super 로 구분해야한다.
        //this.speed 변수가 존재하지 않다면 this를 써도 부모의 변수를 찾아간다.
        return this.speed;  //this.speed
    }
}