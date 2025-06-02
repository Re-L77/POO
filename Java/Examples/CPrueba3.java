package Examples;
public class CPrueba3 {
    public static double sumar(double v1, double v2) {
            return v1 + v2;
    }
    public static void main(String[] args) {
        /*
         * -----Tipos de datos primitivos-----
         * boolean true/false ocupando 1 byte
         * 
         * char ocupando 2 bytes
         * 
         * entero int ocupa 4 bytes
         * entero corto short ocupa 2 bytes
         * entero largo long ocupa 8 bytes
         * 
         * reales float ocupa 4 bytes
         * reales dobles double ocupa 8 bytes
         * 
         * cadena de caracteres String ocupa 2 bytes por cada caracter
         * -----------------------------------
         */
        // int p = 8;
        // double q = 5.678;
        // byte x = 65;

        // char c = (char)x;
        // System.out.println(c);
        // System.out.println(Math.sqrt(26));

        CJugador j1 = new CJugador(1, "Juan", 10, 5);
        CJugador j2 = new CJugador(2, "Pedro", 9, 3);
        CJugador j3 = new CJugador(3, "Luis", 8, 2);

        CEquipo eq1 = new CEquipo(216, "Test", new CJugador[]{j1, j2, j3}, 2, 5, 4);
        System.out.println(eq1);
    }   
}
