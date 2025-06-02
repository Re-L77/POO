package Examples;
import java.util.concurrent.TimeUnit;
public class CElevador 
{
    boolean puertaAbierta;
    int pisoactual;
    int maxpisos;
    int minpisos;

    public CElevador(boolean puertaAbierta, int pisoactual, int maxpisos, int minpisos) 
    {
        this.puertaAbierta = puertaAbierta;
        this.pisoactual = pisoactual;
        this.maxpisos = maxpisos;
        this.minpisos = minpisos;
    }   
    
    public void abrirPuerta() {
        if (puertaAbierta == false) { 
            // Si la puerta no está abierta...
            System.out.println("Puerta abriéndose ..."); // entonces puedo abrirla
            puertaAbierta = true; // ahora el estado de la puerta es abierta
        } else
            System.out.println("La puerta ya estaba abierta.");
    }

    public void cerrarPuerta() {
        if (puertaAbierta == true) { 
            // Si la puerta está abierta...
            System.out.println("Puerta cerrándose ..."); // entonces puedo cerrarla
            puertaAbierta = false; // ahora el estado de la puerta es cerrada
        } else
            System.out.println("La puerta ya estaba cerrada.");
    }
    

    public void subir() {
        if (puertaAbierta == false) { 
            if (pisoactual + 1 > maxpisos) { 
                System.out.println("No puedo subir más allá del piso " + maxpisos);
            } else {
                System.out.println("Subiendo al piso " + (pisoactual + 1));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                pisoactual++;
            }
        } else
            System.out.println("No puedo subir con la puerta abierta.");
    }

    public void bajar () {
        if (puertaAbierta == false) { 
            if (pisoactual - 1 < minpisos) { 
                System.out.println("No puedo bajar más allá del piso " + minpisos);
            } else{
                System.out.println("Bajando al piso " + (pisoactual - 1));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                pisoactual--;
            }
        } else
            System.out.println("No puedo subir con la puerta abierta.");
    }

    public void irAPiso(int piso) {
        if (puertaAbierta == false) { 
            // si la puerta no está abierta...
            if (piso > maxpisos || piso < minpisos) 
            { 
                System.out.println("No puedo ir al piso " + piso);
            } 
            else{
                if (piso != pisoactual) {
                    if (piso > pisoactual) {
                        int subir = piso - pisoactual;
                        for (int i = 0; i < subir; i++) {
                            subir();
                        }
                    } else {
                        int bajar = pisoactual - piso;
                        for (int i = 0; i < bajar; i++) {
                            bajar();
                        }
                    }
                } else {
                    System.out.println("Ya estoy en el piso " + piso);
                }
            }
        } 
        else
            System.out.println("No puedo subir con la puerta abierta.");
    }
}
