package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level2 extends JPanel implements ActionListener, KeyListener {

    int naveAncho = 40;
    int naveAlto = 20;
    int naveX = 256;
    int naveY = 480;
    int naveSpeed = 5;

    int disparoAncho = 5;
    int disparoAlto = 10;
    int disparoVel = 10;

    ArrayList<Rectangle> enemigos = new ArrayList<>();

    public Level2() {
        setPreferredSize(new Dimension(512,512));
        setBackground(Color.BLACK);

        setFocusable(true);



    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Nivel 2");
        Level2 l2 = new Level2();

        frame.add(l2);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
b

}
