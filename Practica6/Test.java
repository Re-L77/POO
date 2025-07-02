package Practica6;

public class Test {
    public static void main(String[] args) {
        CA_Animal fish = new Fish();
        CA_Animal cat = new Spider();
        I_Pet pet = new Cat("Gato");
        fish.eat();
        fish.walk();
        fish.play();

        cat.eat();
        cat.walk();
        cat.play();

        pet.eat();
        pet.walk();
        pet.play();
    }
}
