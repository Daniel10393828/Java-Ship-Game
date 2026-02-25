package main;
import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;

public class Menu extends JPanel {

    public Menu() {
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);
        JLabel titulo = new JLabel("SPACE INVADER");
        titulo.setForeground(Color.GREEN);
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(90, 60, 400, 50);
        add(titulo);

        JLabel nivel = new JLabel("DIFICULTAD:");
        nivel.setForeground(Color.WHITE);
        nivel.setFont(new Font("Arial", Font.PLAIN, 18));
        nivel.setBounds(180, 160, 120, 30);
        add(nivel);

        //NIVELES
        int bLado = 40+25;
        JButton boton = new JButton(" ");
        boton.setBounds(20,300,40,40);
        add(boton);
        boton.addActionListener (e ->{
            App.cardLayout.show(App.contenedor, "GAME");
            // Pedir focus correctamente
            SwingUtilities.invokeLater(() -> {
                App.game.requestFocusInWindow();
            });
        });
        JButton b2 = new JButton();
        b2.setBounds(20+bLado, 300,40,40);
        add(b2);

        JButton b3 = new JButton();
        b3.setBounds(20+bLado*2,300,40,40);
        add(b3);
        JButton b4 = new JButton();
        b4.setBounds(20+bLado*3,300,40,40);
        add(b4);
        JButton b5 = new JButton();
        b5.setBounds(20+bLado*4,300,40,40);
        add(b5);
        JButton b6 = new JButton();
        b6.setBounds(20+bLado*5,300,40,40);
        add(b6);
        JButton b7 = new JButton();
        b7.setBounds(20+bLado*6,300,40,40);
        add(b7);
        JButton b8 = new JButton();
        b8.setBounds(20+bLado*7,300,40,40);
        add(b8);
        String[] niveles = {"Fácil"};
        JComboBox<String> selectorNivel = new JComboBox<>(niveles);
        selectorNivel.setBounds(170, 200, 160, 30);
        add(selectorNivel);

        App.cardLayout.show(App.contenedor, "GAME");

        SwingUtilities.invokeLater(() -> {
            App.game.requestFocusInWindow();
});

    }

    //COMO ENTRA UNA VENTANA
    public static void main (String[]args){
        JFrame frame = new JFrame("Space Invader Trucho");
        SpaceInvader game = new SpaceInvader();

        frame.add(game);
        frame.pack();
        frame.setSize(16*34,16*34);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}