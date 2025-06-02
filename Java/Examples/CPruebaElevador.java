package Examples;
public class CPruebaElevador 
{
    public static void main(String[] args) {
        CElevador elevador = new CElevador(false, 1, 10, 1);
        elevador.abrirPuerta();
        elevador.cerrarPuerta();
        elevador.subir();
        elevador.subir();
        elevador.subir();
        elevador.subir();
        elevador.bajar();
        elevador.bajar();
        // System.out.println(elevador.pisoactual);
        elevador.irAPiso(3);
        elevador.irAPiso(2);
    }
}
