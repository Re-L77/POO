package Examples;
import java.awt.*;
import javax.swing.*;
public class CVentana extends JFrame {
    JButton btnAceptar;
    JButton btnCancelar;
    JTextField txtPassword;
    JLabel lblPassword;
    JPanel p1;
    JPanel p2;

    CVentana() {
        p1 = new JPanel();
        p2 = new JPanel();
        setTitle("Mi Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        txtPassword = new JTextField(25);
        lblPassword = new JLabel("Password:");
        add(lblPassword);
        add(txtPassword);
        add(btnAceptar);
        add(btnCancelar);
        p1.add(lblPassword);
        p1.add(txtPassword);
        p2.add(btnAceptar);
        p2.add(btnCancelar);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new CVentana();
    }
}
