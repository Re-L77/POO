package Pac_man;

public class Personaje {
    String nombre;
    String color = "Amarillo";

    void mover(char p) { // A izquierda, D derecha, W arriba, S abajo
        System.out.println(nombre + " se mueve hacia " + p);
    }

    void comer() {
        System.out.println(nombre + " come");
    }

    void renacer() {
        System.out.println(nombre + " renace");
    }
}
