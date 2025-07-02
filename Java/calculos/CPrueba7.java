package calculos;

import java.math.BigDecimal;
import java.util.Arrays;

class CPrueba7 {

    public static void imprimir(int b[]) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "-");
        }
        System.out.println();
    }

    public static int sumar(int b[]) {
        int total = 0;
        for (int i = 0; i < b.length; i++) {
            total += b[i];
        }
        return total;
    }

    public static boolean verificar(int e, int b[]) {

        for (int i = 0; i < b.length; i++) {
            if (e == b[i])
                return true;
        }
        return false;
    }

    public static void obtenPares(int b[]) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 0)
                System.out.print("Par: " + b[i]);
        }
    }
   
    public static double fibo(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
                return 1;
            else
                return fibo(n-1) + fibo(n-2);
    }

        // Versión iterativa de Fibonacci con BigDecimal
    public static BigDecimal fibo_ite(int n) {
        BigDecimal z = BigDecimal.ZERO, x = BigDecimal.ZERO, y = BigDecimal.ONE;
        if (n < 0) {
            return BigDecimal.valueOf(-1);
        } else if (n == 0) {
            return BigDecimal.ZERO;
        } else if (n == 1) {
            return BigDecimal.ONE;
        }
        for (int i = 2; i <= n; i++) {
            z = x.add(y);
            x = y;
            y = z;
        }
        return z;
    }

    public static double potencia(int b, int e) {
        if (e == 0)
            return 1;
        else
            return b * potencia (b, e-1);
    }

    // versión iterativa de impresión de un intervalo de enteros
    public static void secuencia(int n) {
        int i = 1;
        while (n >= i) {
            System.out.print(i + "-");
            i++;
        }
    }

    // versión recursiva de impresión de un intervalo de enteros
    public static void secuenciaRec(int n) {
        if (n == 1)
            System.out.print("1-");
        else {
            secuenciaRec(n-1);
            System.out.print(n + "-");
        }

    }

    public static int metodo(int x) {
        int p = 3;
        x--;
        return p + x;
    }

    public static void main(String[] args) {
        CPrueba7 obj = new CPrueba7();

        //System.out.println(potencia(2, 10));
        //secuenciaRec(20);
        int x = 5;
        System.out.println(metodo(x));
        System.out.println("El valor de x es: " + x);

        //int b[] = {5,6,7,8,3,2,4,9,3,0};
        //imprimir(b);
        //System.out.println(sumar(b));
        //System.out.println(verificar(1, b));
        //Arrays.sort(b);
        //imprimir(b);
        //obtenPares(b);
   
    }
}    
        /* 
        Enemigo e1 = new Enemigo("inky", "rosa");
        Enemigo e2 = new Enemigo("pinky", "rojo");
        Enemigo e3 = new Enemigo("blinky", "azul");
        Enemigo fantasmas[] = new Enemigo[3];
        fantasmas[0] = e1;
        fantasmas[1] = e2;
        fantasmas[2] = e3;
        System.out.println();
        */