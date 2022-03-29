package javastudy.day4.oop5;

public class Animal {
    public void cry(){
        System.out.println("부모가 정의한 울음소리");
    }
}

class Dog extends Animal{
    @Override
    public void cry() {
        System.out.println("woof! woof!");
    }
}

class Cat extends Animal{
    @Override
    public void cry() {
        System.out.println("Meow~");
    }
}

class st{
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal = new Animal();

        dog.cry();
        cat.cry();
        animal.cry();
    }
}