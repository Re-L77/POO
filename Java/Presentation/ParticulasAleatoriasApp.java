package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticulasAleatoriasApp extends JFrame {

    private JTextField depthInputField;
    private JLabel statusLabel;
    private DrawingPanel drawingPanel;
    private Timer animationTimer;
    private Random random = new Random();

    // --- Parámetros ajustables para la demostración ---
    private int MAX_EXPLOSION_DEPTH_FOR_SOE = 10000; // Profundidad alta para StackOverflowError en la generación
    private int PARTICLES_PER_EXPLOSION = 5;      // Cuántas partículas genera cada 'explosión' recursiva
    private int MAX_TOTAL_PARTICLES_FOR_OOM = 1_000_000; // Límite para OutOfMemoryError
    private int ANIMATION_DELAY_MS = 16;            // Velocidad de la animación (aproximadamente 60 FPS)
    private int PARTICLE_SPEED = 3;                 // Velocidad máxima de movimiento de las partículas
    private int PARTICLE_SIZE = 4;                  // Tamaño de cada partícula
    private double CHANCE_TO_SPAWN_CHILDREN = 0.5; // Probabilidad de que una nueva partícula "explote" más

    public ParticulasAleatoriasApp() {
        setTitle("Simulación de Partículas Aleatorias");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        controlPanel.add(new JLabel("Profundidad de Explosión (número):"));
        depthInputField = new JTextField("3", 5); // Profundidad inicial baja para ver movimiento sin abrumar
        controlPanel.add(depthInputField);

        JButton startSimButton = new JButton("Iniciar Simulación");
        controlPanel.add(startSimButton);

        JButton stopSimButton = new JButton("Detener Simulación");
        controlPanel.add(stopSimButton);

        JButton clearButton = new JButton("Limpiar");
        controlPanel.add(clearButton);

        statusLabel = new JLabel("Listo.");
        controlPanel.add(statusLabel);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(Color.DARK_GRAY);
        add(controlPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        // Configuración del temporizador para la animación
        animationTimer = new Timer(ANIMATION_DELAY_MS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.updateParticles();
                drawingPanel.repaint();
                statusLabel.setText("Partículas: " + drawingPanel.getParticleCount() + " | FPS: " + (1000 / ANIMATION_DELAY_MS));
            }
        });

        // --- Action Listeners ---
        startSimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int depth = Integer.parseInt(depthInputField.getText());
                    if (depth < 0) {
                        statusLabel.setText("Error: La profundidad debe ser un número positivo.");
                        return;
                    }

                    animationTimer.stop();
                    drawingPanel.clearParticles(); // Limpiar partículas previas
                    statusLabel.setText("Generando partículas...");

                    // Iniciar la generación recursiva de partículas en un nuevo hilo
                    new Thread(() -> {
                        try {
                            // Generar la primera "explosión"
                            drawingPanel.generateParticleExplosion(
                                drawingPanel.getWidth() / 2, drawingPanel.getHeight() / 2, // Centro
                                PARTICLES_PER_EXPLOSION, 0, depth // Número de partículas, profundidad actual, maxDepth
                            );
                            SwingUtilities.invokeLater(() -> {
                                animationTimer.start(); // Iniciar animación solo después de generar
                                statusLabel.setText("Simulación iniciada. Partículas: " + drawingPanel.getParticleCount());
                            });
                        } catch (StackOverflowError soe) {
                             SwingUtilities.invokeLater(() -> {
                                animationTimer.stop(); // Detener animación
                                statusLabel.setText("¡ERROR DE MEMORIA (Stack Overflow)! La generación recursiva fue demasiado profunda.");
                                JOptionPane.showMessageDialog(ParticulasAleatoriasApp.this,
                                        "Se produjo un StackOverflowError durante la generación de partículas. Esto ocurre cuando las llamadas recursivas exceden la capacidad de la pila de memoria (stack). Es un tipo de Error.",
                                        "Error de Memoria (Stack Overflow)",
                                        JOptionPane.ERROR_MESSAGE);
                            });
                        } catch (OutOfMemoryError oome) {
                             SwingUtilities.invokeLater(() -> {
                                animationTimer.stop(); // Detener animación
                                statusLabel.setText("¡ERROR DE MEMORIA (Out Of Memory)! No hay suficiente memoria heap.");
                                JOptionPane.showMessageDialog(ParticulasAleatoriasApp.this,
                                        "Se produjo un OutOfMemoryError. Esto ocurre cuando la aplicación intenta asignar más memoria de la que el heap de la JVM tiene disponible para almacenar las partículas. Es un tipo de Error.",
                                        "Error de Memoria (Out Of Memory)",
                                        JOptionPane.ERROR_MESSAGE);
                            });
                        } catch (Exception ex) {
                            SwingUtilities.invokeLater(() -> statusLabel.setText("Error inesperado: " + ex.getMessage()));
                            ex.printStackTrace();
                        }
                    }).start();

                } catch (NumberFormatException ex) {
                    statusLabel.setText("Error: Ingresa un número válido para la profundidad.");
                }
            }
        });

        stopSimButton.addActionListener(e -> {
            animationTimer.stop();
            statusLabel.setText("Simulación detenida.");
        });

        clearButton.addActionListener(e -> {
            animationTimer.stop();
            drawingPanel.clearParticles();
            drawingPanel.repaint();
            statusLabel.setText("Panel limpiado.");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ParticulasAleatoriasApp().setVisible(true);
        });
    }

    // --- Inner Class for Particle Object ---
    class Particula {
        double x, y;
        double dx, dy; // Velocidad en X y Y
        Color color;

        public Particula(double x, double y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
            // Movimiento aleatorio
            this.dx = (random.nextDouble() * 2 - 1) * PARTICLE_SPEED; // entre -PARTICLE_SPEED y +PARTICLE_SPEED
            this.dy = (random.nextDouble() * 2 - 1) * PARTICLE_SPEED;
        }

        public void update(int panelWidth, int panelHeight) {
            x += dx;
            y += dy;

            // Rebotar en los bordes
            if (x < PARTICLE_SIZE / 2 || x > panelWidth - PARTICLE_SIZE / 2) {
                dx *= -1;
                x = Math.max(PARTICLE_SIZE / 2, Math.min(x, panelWidth - PARTICLE_SIZE / 2)); // Ajustar para no salirse
            }
            if (y < PARTICLE_SIZE / 2 || y > panelHeight - PARTICLE_SIZE / 2) {
                dy *= -1;
                y = Math.max(PARTICLE_SIZE / 2, Math.min(y, panelHeight - PARTICLE_SIZE / 2));
            }
            // Pequeña probabilidad de cambiar de dirección para más aleatoriedad
            if (random.nextDouble() < 0.01) {
                 dx = (random.nextDouble() * 2 - 1) * PARTICLE_SPEED;
                 dy = (random.nextDouble() * 2 - 1) * PARTICLE_SPEED;
            }
        }

        public void draw(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillOval((int) (x - PARTICLE_SIZE / 2), (int) (y - PARTICLE_SIZE / 2), PARTICLE_SIZE, PARTICLE_SIZE);
        }
    }

    // --- Custom JPanel for Drawing ---
    class DrawingPanel extends JPanel {
        private List<Particula> particles = new ArrayList<>();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            for (Particula p : particles) {
                p.draw(g2d);
            }
        }

        public void updateParticles() {
            // Actualizar la posición de todas las partículas
            for (Particula p : particles) {
                p.update(getWidth(), getHeight());
            }
        }

        /**
         * Genera una "explosión" de partículas de forma recursiva.
         * @param x X central de la explosión
         * @param y Y central de la explosión
         * @param numToSpawn Cuántas partículas crear en esta "explosión"
         * @param currentDepth Profundidad actual de recursión
         * @param maxDepth Profundidad máxima de recursión (introducida por el usuario)
         */
        public void generateParticleExplosion(double x, double y, int numToSpawn, int currentDepth, int maxDepth) {
            // CORRECCIÓN: Ahora se utiliza MAX_EXPLOSION_DEPTH_FOR_SOE como un límite adicional.
            // La recursión se detendrá si alcanza la profundidad deseada por el usuario (maxDepth)
            // O si alcanza el límite predefinido en el código para forzar el StackOverflowError.
            if (currentDepth >= maxDepth || currentDepth >= MAX_EXPLOSION_DEPTH_FOR_SOE) {
                return;
            }

            // Simulación de OutOfMemoryError: verificar el total de partículas
            if (particles.size() > MAX_TOTAL_PARTICLES_FOR_OOM) {
                 throw new OutOfMemoryError("Simulación: Exceso de partículas creadas, agotando la memoria del heap!");
            }

            // Generar partículas para esta explosión
            for (int i = 0; i < numToSpawn; i++) {
                // Color aleatorio para las partículas
                Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                // Ligeramente dispersas alrededor del centro
                double spawnX = x + (random.nextDouble() * 40 - 20); // +/- 20 pixels
                double spawnY = y + (random.nextDouble() * 40 - 20);
                particles.add(new Particula(spawnX, spawnY, randomColor));

                // Recurrir: Algunas partículas tienen la chance de generar más hijos
                // Esto es lo que puede provocar el StackOverflow si la profundidad es muy grande.
                // Asegúrate de que la recursión no exceda maxDepth o MAX_EXPLOSION_DEPTH_FOR_SOE.
                // Se añade la condición para asegurar que la recursión se detenga también por el límite predefinido.
                if (random.nextDouble() < CHANCE_TO_SPAWN_CHILDREN) {
                    generateParticleExplosion(spawnX, spawnY, numToSpawn, currentDepth + 1, maxDepth);
                }
            }
        }

        public void clearParticles() {
            particles.clear();
        }

        public int getParticleCount() {
            return particles.size();
        }
    }
}