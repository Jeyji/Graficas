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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPaintComponent extends JFrame{
    public TestPaintComponent(){
        add(new NewPanel());
    }  

    public static void main(String[] args) {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(1024,520);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }      

    
}

class NewPanel extends JPanel implements ActionListener, MouseListener {        
    private Timer time;
    private int x;

    
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
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        int y = 50;
        if(t==false){
            g.fillRect(400, 380, 50, 40);
            g.setColor(Color.BLUE);
            g.fillRect(x+0, 380, 200, 40);
        }else{
            g.setColor(Color.BLUE);
            g.fillRect(x+0-50, 380, 200+y, 40);
        }
        x++;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        repaint();
    }
    public NewPanel() {
        time = new Timer(25, this);
        this.time.start();
        this.x = 10;
        this.addMouseListener(this);
        
    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle (x-10, 20, 220, 160);
    }

    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon("fondo.png");
        Image image = ii.getImage();
        return image;
    }
}