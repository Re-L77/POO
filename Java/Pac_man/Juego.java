package Pac_man;

public class Juego {
    public static void main(String[] args) {
        Heroe h1 = new Heroe("Mr. Pacman", 3);
        Enemigo e1 = new Enemigo("Inky", "rosa");
        Enemigo e2 = new Enemigo("Pinky", "rojo");
        Fruta f1 = new Fruta("Cereza", 10, 'N');
        h1.mover('I');
        h1.mover('A');
        e1.mover('B');
        e2.mover('B');
        h1.comer(20);
        h1.comer(e1);
        h1.comer(f1);
    }
}