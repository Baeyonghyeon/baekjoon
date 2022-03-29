package javastudy.day4.oop;

public class Horse {
    private int power = 10;
    public void run(){  //말은 달릴 수 있다.
        power--;
        System.out.println("다가닥~ 다가닥~");
    }
}

class Unicorn extends Horse{    //유니콘을 말을 상속
    private int magicPower = 10;
    public void doMagic(){
        magicPower--;
        System.out.println("마법을 부립니다.");
    }
}

class Inherit{
    public static void main(String[] args) {
        //Horse horse = new Horse();
        //horse.run();

        Unicorn unicorn = new Unicorn();
        unicorn.run();
        unicorn.doMagic();
    }
}
