public class Practica1 {
    public static void main(String[] args) {
        // 1.
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + "--");
        }
        System.out.println();

        // 2.
        int p = 7, q = 9;
        if (p > q) {
            System.out.println("p es mayor que q");
        } else if (p < q) {
            System.out.println("q es mayor que p");
        } else {
            System.out.println("p y q son iguales");
        }

        // 3-4. 
        int n = 6;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 5-7. 
        int b = 2, e = 8;
        int resultado = 1;
        for (int i = 0; i < e; i++) {
            resultado *= b;
        }
        System.out.println(b + "^" + e + " es: " + resultado);

        // 8-10.jva
        int[] a = {5, 3, 9, 0, 2, 4, 8, 5};
        int aux;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
            }
        }
        System.out.println("Valor máximo: " + a[a.length - 1]);
    }    
}
