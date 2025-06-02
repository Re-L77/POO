package Examples;
public class GetEnv {
    public static void main(String[] args) {
    System.out.println("Hola, soy Juan.");
    System.out.println("------------------");
    System.out.println("Variables de entorno:");
    System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
    System.out.println(System.getenv("NUMBER_OF_PROCESSORS"));
    System.out.println(System.getenv("USERNAME"));
    System.out.println(System.getenv("TEMP"));
    }   
}