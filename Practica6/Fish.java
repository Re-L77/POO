package Practica6;

public class Fish extends CA_Animal implements I_Pet {
    public Fish() {
        super(0);
    }

    
    void walk() {
        System.out.println("Los peces no pueden caminar.");
    }

    public void play() {
        System.out.println("Los peces no juegan.");
    }

    void eat() {
        System.out.println("Un pez come plancton.");
    }
}
