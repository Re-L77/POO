package Presentation;

public class IntExcepcion02 {
    
    public static int dividir(){
        int numerador = 10;
        int denominador = 0;
        return numerador / denominador; 
    }

    public static void main(String[] args) {
        try{
            int res = dividir();
            System.out.println("El resultado de la división es: " + res);
        } catch(ArithmeticException e){
            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("El programa continua");
        
    }
}
