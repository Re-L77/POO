package calculos;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

import javax.swing.*;

public class calculos extends JFrame {
    JPanel pValor, pBotones;
    JLabel lblValor, lblResultado;
    JTextField txtValor;
    JButton btnCalcularFibonacci, btnCalcularFactorial;

    calculos() {
        pValor = new JPanel();
        pBotones = new JPanel();
        lblValor = new JLabel("Valor:");
        lblResultado = new JLabel("Resultado:");
        txtValor = new JTextField(15);
        btnCalcularFibonacci = new JButton("Fibonacci");
        btnCalcularFactorial = new JButton("Factorial");

        pValor.add(lblValor);
        pValor.add(txtValor);

        btnCalcularFibonacci.addActionListener(actionListener);
        btnCalcularFactorial.addActionListener(actionListenerFactorial);
        pBotones.add(btnCalcularFibonacci);
        pBotones.add(btnCalcularFactorial);

        add(pValor, BorderLayout.NORTH);
        add(lblResultado, BorderLayout.CENTER);
        add(pBotones, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

    // Versión recursiva de Fibonacci
    public static double fibo(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
                return 1;
            else
                return fibo(n-1) + fibo(n-2);
    }

    // Versión iterativa de Fibonacci con BigDecimal
    public static BigDecimal fibo_ite(int n) {
        BigDecimal z = BigDecimal.ZERO, x = BigDecimal.ZERO, y = BigDecimal.ONE;
        if (n < 0) {
            return BigDecimal.valueOf(-1);
        } else if (n == 0) {
            return BigDecimal.ZERO;
        } else if (n == 1) {
            return BigDecimal.ONE;
        }
        for (int i = 2; i <= n; i++) {
            z = x.add(y);
            x = y;
            y = z;
        }
        return z;
    }

    public static BigDecimal factorial(int n) {
        if (n < 0) {
            return BigDecimal.valueOf(-1); // Error for negative input
        }
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Vas a calcular el fibonacci!");
            // System.out.println(fibo_ite(Integer.parseInt(txtValor.getText())));
            // lblResultado.setText("Resultado: " + fibo_ite(Integer.valueOf(txtValor.getText())));
            
            if (txtValor.getText().isEmpty()) {
                lblResultado.setText("Resultado: Error al calcular");
                JOptionPane.showMessageDialog(null, "El campo de valor está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                BigDecimal num = fibo_ite(Integer.parseInt(txtValor.getText()));
                if (num.compareTo(BigDecimal.ZERO) < 0) {
                    lblResultado.setText("Resultado: ERROR");
                    JOptionPane.showMessageDialog(null, "El número no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    lblResultado.setText("Resultado: " + num.toString());
                    pack(); // Ajusta el tamaño de la ventana después de agregar componentes
                    JOptionPane.showMessageDialog(null, "El resultado es: " + num.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    };    

    // ActionListener para el botón de calcular factorial
    ActionListener actionListenerFactorial = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Vas a calcular el factorial!");
            if (txtValor.getText().isEmpty()) {
                lblResultado.setText("Resultado: Error al calcular");
                JOptionPane.showMessageDialog(null, "El campo de valor está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                BigDecimal num = factorial(Integer.parseInt(txtValor.getText()));
                if (num.compareTo(BigDecimal.ZERO) < 0) {
                    lblResultado.setText("Resultado: ERROR");
                    JOptionPane.showMessageDialog(null, "El número no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    lblResultado.setText("Resultado: " + num.toString());
                    pack(); // Ajusta el tamaño de la ventana después de agregar componentes
                    JOptionPane.showMessageDialog(null, "El resultado es: " + num.toString(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
        }
    };
    public static void main(String[] args) {
        new calculos();
        
    }

}