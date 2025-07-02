package Presentation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {

    public static String leerArchivo() throws IOException {
        FileReader reader = new FileReader("c:/Users/jpabl/OneDrive/Escritorio/github/POO/Java/Presentation/c:/Users/jpabl/OneDrive/Escritorio/github/POO/Java/Presentation/archivo.txt");
        try (BufferedReader buffer = new BufferedReader(reader)) {
            String line = buffer.readLine();
            return line;
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println(leerArchivo());
    }
}
