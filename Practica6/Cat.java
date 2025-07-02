package Practica6;

public class Cat extends CA_Animal implements I_Pet {
    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public Cat() {
        this("");
    }

    public void play () {
        if (name == "")
            System.out.println("Un gato juega con bolas de estambre.");
        else
            System.out.println("El gato " + name + " juega con bolas de estambre.");
    }

    public void eat() {
        if (name == "")
            System.out.println("Un gato come pescado.");
        else
            System.out.println("El gato " + name + " come pescado.");
    }

    public void walk() {
        if (name == "")
            System.out.println("Un gato camina con 4 patas.");
        else
            System.out.println("El gato " + name + " camina con 4 patas.");
    }
}
