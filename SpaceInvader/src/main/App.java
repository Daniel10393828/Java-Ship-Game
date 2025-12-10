package main;
import javax.swing.*;

public class App{
    public static void main (String []args )throws Exception{
        int tam = 32;
        int ancho = 16;
        int alto = 16;
        int pantalla_alto = tam*alto;
        int pantalla_ancho = tam*ancho;
        JFrame frame = new JFrame("Space Invader Trucho");
        frame.setSize(pantalla_ancho,pantalla_alto);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        SpaceInvader space = new SpaceInvader();
        frame.add(space);
        frame.pack();
        frame.setVisible(true);
    }
}