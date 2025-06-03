package Pac_man;

public class Enemigo extends Personaje {
    Enemigo(String n, String c) {
        nombre = n;
        color = c;
    }

    void comer(Heroe h) {
        System.out.println(nombre + " come a " + h.nombre);
    }    
}
