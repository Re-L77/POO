package INTERFACE_CLASS_ABSTRACT;

public class Triangulo implements IFigura {
    double base, altura;
    public double calcularArea() {
        System.out.println("Calculando área del triángulo");
        return base * altura / 2;
    }

    public double calcularArea(double b) {
        System.out.println("Calculando área del triángulo");
        return b * altura / 2;
    }

}
