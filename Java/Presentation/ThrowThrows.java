package Presentation;

public class ThrowThrows {
    public static void main(String[] args) {
        String estadisticas = "clicks=30, paginas=10, sesiones=5";
        try {
            enviarAlServidor(estadisticas);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void enviarAlServidor(String estadisticas) throws Exception {
        if(estadisticas == null || estadisticas.isEmpty()) {
            System.out.print("Las estadísticas no pueden estar vacías");
            Exception excep = new Exception("LAs estadisticas están vacias");
            
            throw excep;
        }
    }
}
