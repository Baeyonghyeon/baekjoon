package java.javastudy.day4.oop4;

public class Cd {
    public String getName() {
        return name;
    }

    String name;

    public Cd(String name){
        this.name = name;
    }
}

class Computer{
    public static void main(String[] args) {
        Cd cd = new Cd("노래모음");
        Dvd dvd = new Dvd("영화모음");
        Computer computer = new Computer();
        computer.play(cd);
        computer.play(dvd);
    }
    //new 를 하지 않아도 외부에서 주입받아도 합성이다.
    //즉. 다른 객체를 가지고 있으면 합성이라 한다.
    DvdDrive dvdDrive = new DvdDrive();

    public void play(Cd cd) {
        dvdDrive.play(cd);
    }

    public void play(Dvd dvd){
        dvdDrive.play(dvd);
    }
}
class Dvd{
    String name;

    public String getName() {
        return name;
    }

    public Dvd(String name){
        this.name = name;
    }
}
class CdDrive{
    public void play(Cd cd){
        System.out.println(cd.getName() + "cd 실행");
    }
}
class DvdDrive extends CdDrive{
    public void play(Dvd dvd){
        System.out.println(dvd.getName() + "dvd 실행");
    }
}