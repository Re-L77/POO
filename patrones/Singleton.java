package patrones;
import java.awt.*;
import javax.swing.*;

public class Singleton extends JFrame {
    private static Singleton uniqueInstance;
    JPanel pIzq, pCentro, pDer;
    JButton btnPasar, btnRegresar;
    List listaIzq, listaDer; // pregúntese porqué lista de awt y no de swing
    JLabel lblIzq, lblDer;

    private Singleton() {
        pIzq = new JPanel();
        pCentro = new JPanel();
        pDer = new JPanel();
        btnPasar = new JButton(">>");
        btnRegresar = new JButton("<<");
        listaIzq = new List();
        listaDer = new List();

        listaIzq.add("Querétaro");
        listaIzq.add("Colima");
        listaIzq.add("CDMX");
        listaIzq.add("Veracruz");

        lblIzq = new JLabel("Total: " + String.valueOf(listaIzq.getItemCount()));
        lblIzq.setHorizontalAlignment(SwingConstants.CENTER);
        lblDer = new JLabel("Total: 0", 10);
        lblDer.setHorizontalAlignment(SwingConstants.CENTER);

        pIzq.setLayout(new BorderLayout());
        pIzq.add(listaIzq, BorderLayout.CENTER);
        pIzq.add(lblIzq, BorderLayout.SOUTH);

        pCentro.setLayout(new GridLayout(3, 1, 0, 10));
        pCentro.add(btnPasar);
        pCentro.add(btnRegresar);

        pDer.setLayout(new BorderLayout());
        pDer.add(listaDer, BorderLayout.CENTER);
        pDer.add(lblDer, BorderLayout.SOUTH);

        add(pIzq, BorderLayout.WEST);
        add(pCentro, BorderLayout.CENTER);
        add(pDer, BorderLayout.EAST);

        pack();
        setTitle("Traspaso de información");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }    

    public static void main(String[] args) {
        getInstance();
        getInstance();
        getInstance();
        getInstance();
    }
}