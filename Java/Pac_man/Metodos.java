package Pac_man;

import java.util.Arrays; 
public class Metodos {
    public static int sumar (int a, int b) {
        return a + b;
    }
    public static void imprimir (int b[]) {
        // for (int i = 0; i < b.length; i++) {
        //     System.out.print(b[i] + " ");
        // }
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int sumarArreglo(int b[]) {
        int suma = 0;
        for (int i : b) {
            suma += i;
        }
        return suma;
    }

    public static boolean verificarArreglo(int b[], int n) {
        for (int i : b) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    public static void paresArreglo(int b[]) {
        for (int i : b) {
            if (i % 2 == 0) {
                System.out.print("Par: " + i + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        /*
         * firma
         * <tipo de retorno> <nombre del metodo>(<parametros>) {
         *   <cuerpo del metodo>
         * }
         * 
         * *void
         * *tipo primitivo
         * *referencia(objeto)
         * 
         * "static" sirve para que el metodo pueda ser llamado sin necesidad de crear un objeto de la clase
        */
        // System.out.println(sumar(8,5));
        // System.out.println(Math.pow(2, 10));
        int a[] = {5,6,7,8,3,2,4,9,3,0};
        imprimir(a);
        System.out.println(sumarArreglo(a));
        System.out.println(verificarArreglo(a, 5));
        Arrays.sort(a, 0, a.length);
        imprimir(a);
        paresArreglo(a);

        

        // Enemigo e1 = new Enemigo("Inky", "rosa");
        // Enemigo e2 = new Enemigo("Pinky", "rojo");
        // Enemigo fantasmas[] = {e1, e2};
        // for (Enemigo e : fantasmas) {
        //     // System.out.println("Enemigo: " + e.nombre + ", Color: " + e.color);
        //     e.comer();        }
    }
    
}