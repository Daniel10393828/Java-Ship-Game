package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SpaceInvader extends JPanel implements ActionListener, KeyListener {

    // variables de la nave
    int naveAncho = 40;
    int naveAlto = 20;
    int naveX = 256;
    int naveY = 480;
    int nave_speed = 5;
    int disparo_x = naveX+(naveAncho/2);
    int disparo_y = naveY;
    boolean disparo_existencia = false;
    int disparo_ancho = 5;
    int disparo_alto = 10;
    int disparo_speed = 10;
    ArrayList<Rectangle> enemigos = new ArrayList<>();
    ArrayList<Rectangle> disparoArray = new ArrayList();

    public SpaceInvader() {
        setPreferredSize(new Dimension(512, 512));
        setBackground(Color.BLACK);

        generarEnemigos();

        // activar teclado
        setFocusable(true);
        addKeyListener(this);

        // refrescar pantalla
        Timer timer = new Timer(16, this);
        timer.start();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Space Invader Trucho");
        SpaceInvader game = new SpaceInvader();

        frame.add(game);
        frame.pack();  // usa el tamaño del panel (512x512)
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //Disparo


    // crear enemigos 1 sola vez
    public void generarEnemigos() {
        int lado = 20;

        for (int i = 0; i < 300; i += 50) {
            for (int j = 0; j < 200; j += 50) {
                enemigos.add(new Rectangle(i, j, lado, lado));
            }
        }
    }
    //Limites de persoanjes y disparo
    public void limites(){
        if(naveX < 0) naveX = 0;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dibujar nave
        g.setColor(Color.WHITE);
        g.fillRect(naveX, naveY, naveAncho, naveAlto);

        // dibujar enemigos
        g.setColor(Color.GREEN);
        for (Rectangle e : enemigos) {
            g.fillRect(e.x, e.y, e.width, e.height);
        }
        //dibujar disparo
        for (int i = 0; i < disparoArray.size(); i++) {
        Rectangle d = disparoArray.get(i);
        g.setColor(Color.YELLOW);
        g.fillRect(d.x, d.y, d.width, d.height);

        // mover disparo hacia arriba
        d.y -= disparo_speed;

        // eliminar disparo si sale de pantalla
        if (d.y + d.height < 0) {
            disparoArray.remove(i);
            i--;
        }
    }
}
    // KEYLISTENER
    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_A) naveX -= nave_speed;
        if(naveX < 0) naveX = 0;
        if(naveX > 465) naveX = 465;
        if (tecla == KeyEvent.VK_D) naveX += nave_speed;
        if(tecla == KeyEvent.VK_K){
                Rectangle disparo = new Rectangle(naveX,naveY,disparo_ancho,disparo_alto);
                disparoArray.add(disparo);
            }
        }


    @Override
    public void keyReleased(KeyEvent e) {
}
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    // refresco de pantalla
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}