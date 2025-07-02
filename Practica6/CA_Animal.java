package Practica6;

public abstract class CA_Animal {
    protected int legs;
    protected String name;

    public CA_Animal(int legs) {
        this.legs = legs;
    }

    abstract void eat();

    void walk() {
        System.out.println("La mayoría de los animales caminan con " + legs + " patas.");
    }
}
