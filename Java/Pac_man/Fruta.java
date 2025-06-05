package Pac_man;

public class Fruta {
    String nombre;
    int valor;
    char estado;

    Fruta(String n, int v, char e) {
        nombre = n;
        valor = v;
        estado = e;
    }

    Fruta(String n) {
        nombre = n;
    }

    void CambiarEstado(char e) {
        estado = e;
    }
}