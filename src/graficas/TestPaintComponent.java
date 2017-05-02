/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficas;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPaintComponent extends JFrame {
    public TestPaintComponent(){
        add(new NewPanel());
    }  

    public static void main(String[] args) {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }      
}

class NewPanel extends JPanel implements ActionListener{        
    private Timer time;
    public NewPanel() {
        time = new Timer(25, this);
        this.time.start();
    }
    
        
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillOval(40, 120, 40, 40);
        g.fillOval(120, 120, 40, 40);
        g.fillOval(260, 120, 40, 40);
        g.fillOval(340, 120, 40, 40);
        g.fillOval(580, 120, 40, 40);
        g.fillOval(500, 120, 40, 40);
    
        g.drawRect(0, 20, 205, 160);
        g.drawRect(210, 20, 220, 160);
        g.drawRect(445, 20, 220, 160);
            
        g.setColor(Color.BLUE);
        g.fillRect(0, 80, 200, 40);
        int x[] = {80,120,160,40};
        int y[] = {40,40,80,80};
        g.fillPolygon(x, y, x.length);
        g.fillRect(220, 80, 200, 40);
        int z[] = {300,340,380,260};
        int w[] = {40,40,80,80};
        g.fillPolygon(z, w, x.length);
        g.fillRect(460, 80, 200, 40);
        int t[] = {540,580,620,500};
        int p[] = {40,40,80,80};
        g.fillPolygon(t, p, x.length);
        System.out.println("click");
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}