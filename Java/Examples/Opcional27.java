package Examples;

import javax.swing.*;
import java.awt.*;

public class Opcional27 extends JFrame {
    JFrame frame;
    JPanel p1;

    Opcional27() {
        setTitle("Opcional 27");
        setSize(400, 250); // Aumentado el tamaño inicial del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(15, 10)); // Aumentado el espaciado del BorderLayout principal

        // --- Panel Izquierdo ---
        JPanel panelLeft = new JPanel(new BorderLayout());
        String[] left = {"Querétaro", "Colima", "D.F", "Veracruz", "Jalisco", "Nuevo León", "Sonora"}; // Más elementos para visualización
        JList<String> listLeft = new JList<>(left);
        listLeft.setVisibleRowCount(5); // Sugiere un número de filas visibles
        listLeft.setFixedCellWidth(120); // Establece un ancho fijo para las celdas de la lista izquierda
        panelLeft.add(new JScrollPane(listLeft), BorderLayout.CENTER);
        JLabel totalLeft = new JLabel("Total: " + left.length, SwingConstants.CENTER); // Actualiza el total dinámicamente
        panelLeft.add(totalLeft, BorderLayout.SOUTH);

        // --- Panel Central ---
        JPanel panelCenter = new JPanel(new GridBagLayout()); // Usamos GridBagLayout para un control más fino
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0); // Margen vertical para los botones
        gbc.fill = GridBagConstraints.HORIZONTAL; // Hacer que los botones llenen el espacio horizontalmente
        
        JButton b1 = new JButton(">>");
        b1.setPreferredSize(new Dimension(80, 30)); // Establece un tamaño preferido para el botón
        gbc.gridy = 0; // Fila 0
        panelCenter.add(b1, gbc);

        JButton b2 = new JButton("<<");
        b2.setPreferredSize(new Dimension(80, 30)); // Establece un tamaño preferido para el botón
        gbc.gridy = 1; // Fila 1
        panelCenter.add(b2, gbc);

        // --- Panel Derecho ---
        JPanel panelRight = new JPanel(new BorderLayout());
        String[] right = {"D.F", "Querétaro", "Veracruz"};
        JList<String> listRight = new JList<>(right);
        listRight.setVisibleRowCount(5); // Sugiere un número de filas visibles
        listRight.setFixedCellWidth(120); // Establece un ancho fijo para las celdas de la lista derecha
        panelRight.add(new JScrollPane(listRight), BorderLayout.CENTER);
        JLabel totalRight = new JLabel("Total: " + right.length, SwingConstants.CENTER); // Actualiza el total dinámicamente
        panelRight.add(totalRight, BorderLayout.SOUTH);

        add(panelLeft, BorderLayout.WEST);
        add(panelCenter, BorderLayout.CENTER);
        add(panelRight, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Opcional27());
    }
}