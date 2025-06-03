package Pac_man;

public class Heroe extends Personaje {
    int vidas;
    Heroe(String n, int v) {
        nombre = n;
        vidas = v;
    }

    void fortalecer() {
        System.out.println(nombre + " se fortalece...");
    }

    void comer(int fichas) {
        System.out.println(nombre + " come " + fichas + " fichas");
    }
    
    void comer(Enemigo e) {
        System.out.println(nombre + " come a " + e.nombre);
    }
}
