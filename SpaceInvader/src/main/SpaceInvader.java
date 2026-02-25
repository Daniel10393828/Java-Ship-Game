package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SpaceInvader extends JPanel implements ActionListener, KeyListener {

    // Nave
    int naveAncho = 40;
    int naveAlto = 20;
    int naveX = 256;
    int naveY = 480;
    int naveSpeed = 5;

    // Disparo
    int disparoAncho = 5;
    int disparoAlto = 10;
    int disparoSpeed = 10;

    // Listas
    ArrayList<Rectangle> enemigos = new ArrayList<>();
    ArrayList<Rectangle> disparos = new ArrayList<>();

    public SpaceInvader() {
        setPreferredSize(new Dimension(512, 512));
        setBackground(Color.BLACK);

        generarEnemigos();

        setFocusable(true);

        addKeyListener(this);

        Timer timer = new Timer(16, this); // ~60 FPS
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Invader Trucho");
        SpaceInvader game = new SpaceInvader();

        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    // ================= ENEMIGOS =================

    public void generarEnemigos() {
        int lado = 20;

        for (int x = 50; x <= 350; x += 50) {
            for (int y = 50; y <= 200; y += 50) {
                enemigos.add(new Rectangle(x, y, lado, lado));
            }

        }
    }
    int enemigosVelX = 2;   // velocidad horizontal
int enemigosPasoY = 20; // cuanto bajan
boolean moverDerecha = true;
boolean gameOver = false;
    // MOVIMIENTO DE ENEMIGOS
public void moverEnemigo(){

    if(enemigos.isEmpty()) return;

    Rectangle nave = new Rectangle(naveX, naveY, naveAncho, naveAlto);
    boolean cambiarDireccion = false;

    for(Rectangle e : enemigos){

        //  Colisión con la nave
        if(e.intersects(nave)){
            gameOver = true;
        }

        if(moverDerecha && e.x + e.width >= getWidth()){
            cambiarDireccion = true;
        }

        if(!moverDerecha && e.x <= 0){
            cambiarDireccion = true;
        }
    }

    if(cambiarDireccion){
        moverDerecha = !moverDerecha;

        for(Rectangle e : enemigos){
            e.y += enemigosPasoY;

            if(e.y + e.height >= naveY){
                gameOver = true;
            }
        }

    } else {
        for(Rectangle e : enemigos){
            e.x += moverDerecha ? enemigosVelX : -enemigosVelX;
        }
    }

    if(enemigos.size() <= 28/2 && enemigos.size() > 28/3){
        enemigosVelX = 4;
    }
    if(enemigos.size() <= 28/4){
        enemigosVelX = 6;
    }
}

public void reiniciarJuego(){
    enemigos.clear();
    disparos.clear();
    gameOver = false;
    generarEnemigos();
    requestFocusInWindow();
    enemigosVelX = 2;
}

    // ================= DISPAROS =================

    public void moverDisparos() {
        for (int i = 0; i < disparos.size(); i++) {
            Rectangle d = disparos.get(i);
            d.y -= disparoSpeed;

            if (d.y + d.height < 0) {
                disparos.remove(i);
                i--;
            }
        }
    }

    // ================= COLISIONES =================

    public void detectarColisiones() {
        for (int i = 0; i < disparos.size(); i++) {
            Rectangle disparo = disparos.get(i);

            for (int j = 0; j < enemigos.size(); j++) {
                Rectangle enemigo = enemigos.get(j);

                if (disparo.intersects(enemigo)) {
                    enemigos.remove(j);
                    disparos.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    // ================= DIBUJO =================

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Nave
        g.setColor(Color.WHITE);
        g.fillRect(naveX, naveY, naveAncho, naveAlto);
if(enemigos.size() <= 28/4){
    g.setColor(Color.RED);
}
if(enemigos.size() <= 28/2 && enemigos.size() > 28/4){
        g.setColor(Color.ORANGE);
    }
    if(enemigos.size() > 28/2){
        g.setColor(Color.GREEN);
    }

            // Pedir focus correctamente

    for (Rectangle e : enemigos) {
        g.fillRect(e.x, e.y, e.width, e.height);
    }


        // Disparos
        g.setColor(Color.YELLOW);
        for (Rectangle d : disparos) {
            g.fillRect(d.x, d.y, d.width, d.height);
        }
if (gameOver) {
    g.setColor(Color.RED);
    g.setFont(new Font("Arial", Font.BOLD, 36));
    g.drawString("GAME OVER", 150, 250);
}
if(enemigos.isEmpty()){
    g.setColor(Color.WHITE);
    g.setFont(new Font ("Arial", Font.BOLD,36));
    g.drawString("GANASTE",150,250);
}
    }

    // ================= INPUT =================

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_A) naveX -= naveSpeed;
        if (tecla == KeyEvent.VK_D) naveX += naveSpeed;

        // Límites
        if (naveX < 0) naveX = 0;
        if (naveX > getWidth() - naveAncho) naveX = getWidth() - naveAncho;

        // Disparo
        if (tecla == KeyEvent.VK_K) {
            Rectangle disparo = new Rectangle(
                naveX + naveAncho / 2 - disparoAncho / 2,
                naveY,
                disparoAncho,
                disparoAlto
            );
            disparos.add(disparo);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    // ================= LOOP =================

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameOver){
        moverEnemigo();
        moverDisparos();
        detectarColisiones();
        if(enemigos.isEmpty()){
            App.cardLayout.show(App.contenedor, "MENU");
            gameOver = true;
            reiniciarJuego();
        }
        repaint();
    }
    }
}
