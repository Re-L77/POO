public class Cprueba {
    public static void main(String[] args) {
        // CAlumno a1 = new CAlumno();
        // CAlumno a2 = new CAlumno();
        CAlumno a1 = new CAlumno(111, "Juan", 20);
        // CAlumno a2 = new CAlumno(222, "Faye", 22);
        // System.out.println(Math.pow(5, 0));
        if (a1.edad > 18) {
            System.out.println(a1.nombre +" es mayor de edad");
        } else {
            System.out.println(a1.nombre +" es menor de edad");
            
        }
    }
}
