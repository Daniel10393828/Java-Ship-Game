package main;

import java.awt.*;
import javax.swing.*;

public class App {

    public static CardLayout cardLayout;
    public static JPanel contenedor;
    public static SpaceInvader game;
    public static Level2 l2;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Space Invader Trucho");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(16 * 34, 16 * 34);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);
        
        Menu menu = new Menu();
        game = new SpaceInvader();
        l2 = new Level2();
        contenedor.add(menu, "MENU");
        contenedor.add(game, "GAME");
        contenedor.add(l2, "LEVEL2");
        frame.add(contenedor);
        frame.setVisible(true);

    }
}