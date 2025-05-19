public class CEquipo {
    int clave;
    String nombre;
    CJugador jugadores[];
    int jg;
    int jp;
    int je;
    public CEquipo(int clave, String nombre, CJugador[] jugadores, int jg, int jp, int je) {
        this.clave = clave;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.jg = jg;
        this.jp = jp;
        this.je = je;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(clave).append(", Nombre: ").append(nombre).append(", Jugadores: ");
        for (CJugador jugador : jugadores) {
            sb.append(jugador.toString()).append("; ");
        }
        sb.append("JG: ").append(jg).append(", JP: ").append(jp).append(", JE: ").append(je);
        return sb.toString();
    }
}
