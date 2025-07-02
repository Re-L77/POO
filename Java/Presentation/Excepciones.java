package Presentation;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Excepciones {

    public static void metodo1()  {
        try {
            Path archivo = Paths.get("c:/Users/jpabl/OneDrive/Escritorio/github/POO/Java/Presentation/archivo.txt");
            String contenido = Files.readString(archivo);
            System.out.println("Contenido del archivo: " + contenido);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Hola, soy finally xd");
        }
        
    }

    public static void main(String[] args) {
        Excepciones.metodo1();
    }
}