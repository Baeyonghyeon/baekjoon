package java.javastudy.day4.oop9;

public class Super {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        car.speedUp();
        System.out.println("car speed: " + car.getSpeed());

        SuperCar scar = new SuperCar();
        scar.drive();
        scar.speedUp();
        System.out.println("scar speed: " + scar.getSpeed());
    }
}

class Vehicle {
    private int speed;

    void drive() {
        System.out.println("Drive Vehicle");
    }

    void speedUp() {
        speed++;
    }

//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
    int getSpeed() {
        return this.speed;
    }
}

class Car extends Vehicle {
    @Override
    void speedUp() {
        //setSpeed(getSpeed()*2);
        for(int i=0; i<2; i++){
            super.speedUp();
        }
    }
}

class SuperCar extends Car {
    public static final int MAX_SPEED = 300;

    @Override
    void speedUp() {
        //setSpeed(getSpeed()*4);
        for(int i=0; i<2; i++){
            super.speedUp();        //super를 사용해 부모에 접근하다
        }
    }
}
