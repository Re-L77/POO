package Examples;
public class CJugador {
    int id;
    String nombre;
    int numero;
    int goles;

    public CJugador(int id, String nombre, int numero, int goles) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.goles = goles;
    }
    public String toString() {
        return "[ID: " + id + ", Nombre: " + nombre + ", Numero: " + numero + ", Goles: " + goles + "]";
    }
}
