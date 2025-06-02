package Examples;
public class CAlumno {
    int matricula;
    String nombre;
    int edad;
    // Constructor que me permite inicializar los atributos
    // de la clase al momento de crear un objeto
    // CAlumno(int matricula, String nombre, int edad) {
    //     this.matricula = matricula;
    //     this.nombre = nombre;
    //     this.edad = edad;
    // }

    CAlumno(int m, String n, int e) {
        matricula = m;
        nombre = n;
        edad = e;
    }

    // CAlumno() {
    //     matricula = 9999;
    //     nombre = "Indefinido";
    //     edad = 9999;
    // }

    CAlumno() {
        this(9999, "Indefinido", 9999);
    }

    void imprimir() {
        System.out.println("MAT. " + matricula);
        System.out.println("NOMBRE: " + nombre);
        System.out.println("EDAD: " + edad);
    }
}
