package patrones;

public class Autos {
    private int serie = 1;
    String marca;
    String modelo;
    String color;
    private double precio;
    public Autos(int serie, String marca, String modelo, String color, double precio) {
        this.serie = serie;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }
    
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if (precio < 1000000) {
            this.precio = precio;
        } else {
            System.out.println("El precio no puede ser mayor a 1,000,000");
        }
    }

    public int getSerie() {
        return serie;
    }
    public static void main(String[] args) {
        Autos auto1 = new Autos(1, "Toyota", "Corolla", "Rojo", 25000.0);
        System.out.println(auto1.marca + " " + auto1.modelo + " - Color: " + auto1.color + " - Precio: $" + auto1.precio);
    }
}
