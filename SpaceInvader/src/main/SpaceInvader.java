package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class SpaceInvader extends JPanel {

    public SpaceInvader() {
        setPreferredSize(new Dimension(512, 512));
        setBackground(Color.BLACK);
    }

    public static void main(String[] args) throws Exception {

        int tam = 32;
        int ancho = 16;
        int alto = 16;
        int pantalla_alto = tam * alto;
        int pantalla_ancho = tam * ancho;

        JFrame frame = new JFrame("Space Invader Trucho");
        frame.setSize(pantalla_ancho, pantalla_alto);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        SpaceInvader space = new SpaceInvader();
        frame.add(space);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Nave tamaño
        int naveAncho = 40;
        int naveAlto = 20;
        int naveY = 512-naveAlto;
        int naveX = 512/2;


        // Dibujar nave blanca
        g.setColor(Color.WHITE);
        g.fillRect(naveX, naveY, naveAncho, naveAlto);
    }
}