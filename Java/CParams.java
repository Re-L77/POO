public class CParams {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Sin parametros.");
        } else {
            System.out.println("Parametros:");
            System.out.println("Me llamo: " + args[0]);
            System.out.println("Mi edad es: " + args[1] + " años");
            System.out.println("Mi matricula es: " + args[2]);
        }
    }
}