/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficas;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPaintComponent extends JFrame{
    public TestPaintComponent(){
        add(new NewPanel());
    }  

    public static void main(String[] args) {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(1100,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }      

}   

class NewPanel extends JPanel implements ActionListener, MouseListener {        
    private Timer time;
    private int x,y;
    int secuencia;
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if(getBounds().contains(p)){
                time.stop();
                time.start();
            }
        }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }  
    private boolean checkCollisions() {
        Rectangle Carro = this.getBounds();
        Rectangle Muro = new Rectangle(400, 40, 100, 200);
        boolean t = false;
        if(Carro.intersects(Muro)){
            System.out.println("Colision");
            t = true;
        }
        return t;
    } 
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        boolean t = checkCollisions();
        Image fondo = loadImage("blue_background.png");
        Image nube = loadImage("clouds.png");
        Image rojo = loadImage("red_background.png");
        for(x=0; x<50;x++){
            g.drawImage(fondo, x*22, 0, null);           
        }
        for(x=50; x<100;x++){
            g.drawImage(rojo, x*22, 0, null);
        }
        for(x=0; x<50;x++){
            g.drawImage(nube, x*335, 50, null);
        }
        Image tierra = loadImage("ground_loop.png");
        for(x=0; x<50;x++){
            g.drawImage(tierra, x*2*110, 710, null);           
        }
        Image tierr = loadImage("ground_single.png");
        for(x=1; x<50;x++){
            g.drawImage(tierr, x*110, 710, null);           
        }
        Image pie = loadImage("stone.png");
        g.drawImage(pie, 250, 655, null);
        g.drawImage(pie, 500, 655, null);
        g.drawImage(pie, 565, 655, null);
        g.drawImage(pie, 630, 655, null);
        g.drawImage(pie, 565, 600, null);
        g.drawImage(pie, 630, 600, null);
        Image coin = loadImage("coin.png");
        g.drawImage(coin, 250, 600, null);
        g.drawImage(coin, 500, 600, null);
        g.drawImage(coin, 570, 545, null);
        g.drawImage(coin, 635, 545, null);
        Image ene = loadImage("enemy_standing.png");
        g.drawImage(ene, 422, 615, 320, 716, this.secuencia*102, 0, (this.secuencia*102)+102, 100, this);
        int o = 0;
        while(o < 50){
            Image run = loadImage("enemy_run.png");
            g.drawImage(run, 1200-y, 615, 1305-y, 716, this.secuencia*(105-y), 0, this.secuencia*(105-y)+(105-y), 101, this);
            o++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        y += 20;
        if(this.secuencia == 1){
            this.secuencia = 0;
        }else{
            this.secuencia++;
        }
        repaint();
    }
    public NewPanel() {
        time = new Timer(1000, this);
        this.time.start();
        this.x = 10;
        this.addMouseListener(this);
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle (x-10, 20, 220, 160);
    }

    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        
        return image;
    }
    
    private class TAdapter extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e){
        }
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_SPACE){
                System.out.println("Espacio");
            }
            if(key == KeyEvent.VK_UP){
                y -=10;
            }
            if(key == KeyEvent.VK_RIGHT){
                x +=10;
            }
            if(key == KeyEvent.VK_DOWN){
                y +=10;
            }
            if(key == KeyEvent.VK_LEFT){
                x -=10;
            }
        }
    }
}