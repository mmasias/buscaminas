package quintanaJuanCarlos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BuscaminasGUI {

    private JFrame frame;
    private JPanel panelTablero;
    private Buscaminas buscaminas;
    private JButton[][] botones;
    private int size;

    public BuscaminasGUI() {
        buscaminas = new Buscaminas();

        // Pedir datos iniciales
        size = Integer.parseInt(JOptionPane.showInputDialog("Selecciona el tamaño del tablero"));
        int minas = Integer.parseInt(JOptionPane.showInputDialog("Selecciona el número de minas"));

        buscaminas.tablero.asignarTablero(size);
        buscaminas.tablero.asignarNumMinas(minas);

        crearVentana();
        actualizarTablero();
    }

    private void crearVentana() {
        frame = new JFrame("Buscaminas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        panelTablero = new JPanel(new GridLayout(size, size));
        botones = new JButton[size][size];

        for (int fila = 0; fila < size; fila++) {
            for (int col = 0; col < size; col++) {
                JButton boton = new JButton("_");
                int f = fila;
                int c = col;

                boton.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            String[] opciones = {"Punto", "Cuadrado completo"};
                            int tipo = JOptionPane.showOptionDialog(frame, "¿Qué tipo de despeje?", "Despejar",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                    null, opciones, opciones[0]);
                            char modo = (tipo == 1) ? 'C' : 'P';
                            boolean vivo = buscaminas.jugador.despejar(buscaminas.tablero, f, c, modo);
                            if (!vivo) {
                                JOptionPane.showMessageDialog(frame, "Has pisado una mina. ¡Juego terminado!");
                                frame.dispose();
                            }
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            buscaminas.jugador.marcar(buscaminas.tablero, f, c);
                        }

                        actualizarTablero();

                        if (buscaminas.tablero.haGanado()) {
                            JOptionPane.showMessageDialog(frame, "¡Felicidades! Has ganado.");
                            frame.dispose();
                        }
                    }
                });

                botones[fila][col] = boton;
                panelTablero.add(boton);
            }
        }

        frame.add(panelTablero, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void actualizarTablero() {
        char[][] casillas = buscaminas.tablero.casillas;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                botones[i][j].setText(String.valueOf(casillas[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuscaminasGUI());
    }
}
