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
    private int x,y,o,es,re,nub,ba;
    private final int ixc = 1200;
    int secuencia, secuencias;
    int up = 0;
    private boolean g1,g2,g3;
    
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
        Rectangle pie0 = this.getBounds();
        Rectangle pie1 = this.get1();
        Rectangle pie2 = this.get2();
        Rectangle pie3 = this.get3();
        Rectangle pie4 = this.get4();
        Rectangle pie5 = this.get5();
        Rectangle man1 = new Rectangle(0, 615+y, 100, 95);
        boolean t = false;
        if(man1.intersects(pie0)|| man1.intersects(pie1)||man1.intersects(pie2)||man1.intersects(pie3)||man1.intersects(pie4)||man1.intersects(pie5)){
            System.out.println("colison");
            t = true;
        }
        return t;
    } 
    private boolean G1(){
        Rectangle coin1 = this.get6();
        Rectangle man3 = new Rectangle(0, 615+y, 100, 95);
        if(man3.intersects(coin1)){
            g1 = true;
        }
        return g1;
    }
    private boolean G2(){
        Rectangle coin2 = this.get7();
        Rectangle man3 = new Rectangle(0, 615+y, 100, 95);
        if(man3.intersects(coin2)){
            g2 = true;
        }
        return g2;
    }
    private boolean G3(){
        Rectangle coin3 = this.get8();
        Rectangle man3 = new Rectangle(0, 615+y, 100, 95);
        if(man3.intersects(coin3)){
            g3 = true;
        }
        return g3;
    }
    private boolean checkCollision(){
        Rectangle pie0 = this.getBounds();
        Rectangle pie1 = this.get1();
        Rectangle pie2 = this.get2();
        Rectangle pie3 = this.get3();
        Rectangle pie4 = this.get4();
        Rectangle pie5 = this.get5();
        Rectangle man2 = new Rectangle(0, 615+y, 100, 100);
        boolean fl = false;
        if(man2.intersects(pie0)|| man2.intersects(pie1)||man2.intersects(pie2)||man2.intersects(pie3)||man2.intersects(pie4)||man2.intersects(pie5)){
            System.out.println("colison");
            fl = true;
        }
        return fl;
    }
    private boolean checkCollisionEne(){
        Rectangle ene1 = this.getEne();
        Rectangle band = this.getWin();
        Rectangle man2 = new Rectangle(20, 615+y, 80, 100);
        boolean en = false;
        if(man2.intersects(ene1)){
            en= true;
            ba = 1;
        }else if(man2.intersects(band)){
            en= true;
            ba = 2;
        }
        return en;
    }
    @Override
    protected void paintComponent(Graphics g){
        boolean en = checkCollisionEne();
        if(en==false){
        super.paintComponent(g);
        boolean t = checkCollisions();
        boolean fl = checkCollision();
        Image fondo = loadImage("blue_background.png");
        
        Image nube = loadImage("clouds.png");
        Image rojo = loadImage("red_background.png");
        for(x=0; x<50;x++){
            g.drawImage(fondo, (x*22)-es, 0, null);           
        }
        for(x=50; x<100;x++){
            g.drawImage(rojo, (x*22)-es, 0, null);
        }
        for(x=100; x<150;x++){
            g.drawImage(fondo, (x*22)-es, 0, null);           
        }
        for(x=-50; x<0;x++){
            g.drawImage(rojo, (x*22)-es, 0, null);
        }
        for(x=0; x<50;x++){
            g.drawImage(nube, (x*335)-es, 50, null);
        }
        Image tierra = loadImage("ground_loop.png");
        for(x=0; x<50;x++){
            g.drawImage(tierra, (x*2*110)-es, 710, null);           
        }
        Image tierr = loadImage("ground_single.png");
        for(x=1; x<50;x++){
            g.drawImage(tierr, (x*110)-es, 710, null);           
        }
        Image pie = loadImage("stone.png");
        g.drawImage(pie, 250-es, 655, null);
        g.drawImage(pie, 500-es, 655, null);
        g.drawImage(pie, 565-es, 655, null);
        g.drawImage(pie, 630-es, 655, null);
        g.drawImage(pie, 565-es, 600, null);
        g.drawImage(pie, 630-es, 600, null);
        Image coin = loadImage("coin.png");
        g1=G1();
        g2=G2();
        g3=G3();
        if(g1==false){
            g.drawImage(coin, 250-es, 600, null);
        }
        if(g2==false){
            g.drawImage(coin, 500-es, 600, null);
        }
        if(g3==false){
            g.drawImage(coin, 635-es, 545, null);
        }
        Image ene = loadImage("enemy_standing.png");
        g.drawImage(ene, 422-es, 615, 320-es, 716, this.secuencia*102, 0, (this.secuencia*102)+102, 100, this);
        Image run = loadImage("enemy_run.png");
        g.drawImage(run, o-es, 615 ,o + 105-es,716,(this.secuencia*105),0,(this.secuencia*105)+105,101,this);
        Image man = loadImage("standing.png");
        Image wal = loadImage("walking.png");
        Image sup = loadImage("jump.png");
        g.drawRect(0, 615+y, 100, 95);
        g.drawRect(0, 615+y, 100, 100);
        g.drawRect(0-es, 716, 2000, 400);
        g.fillRect(1400-es, 615, 20, 100);
        g.setColor(Color.RED);
        g.fillRect(1400-es, 575, 100, 50);
        g.setColor(Color.BLACK);
        int co = 0;
        if(up==0){    
            g.drawImage(man, 0, 615+y, 100, 715+y, this.secuencia*119, 0, (this.secuencia*119)+119, 127, this);
        }else if(up==1){
            g.drawImage(wal, 0, 615+y, 100, 715+y, this.secuencias*119, 0, (this.secuencias*119)+119, 127, this);
            if(fl==false && co == 0){    
                y += 1;
                if (re == 1){    
                    es += 1;
                }
                g.drawImage(sup, 0, 615+y, 85, 110, null);
                fl = checkCollision();
                if(fl==true){
                    fl=false;
                    up = 0;
                    co = 1;
                }
            }
        }else if(up == 2){
            g.drawImage(sup, 0, 615+y, 85, 110, null);
        }else if(up==4){
            g.drawImage(sup, 0, 615+y, 85, 110, null);
            if(fl==false && co == 0){
                y += 1;
                if (re == 1){    
                    es += 1;
                }
                fl = checkCollision();
                if(fl==true){
                    y -= 1;
                    fl=false;
                    co = 1;
                    up = 0;
                    nub = 0;
                }
            }
        }
        g.drawRect(900, 100, 150, 40);
        g.drawString("COINS", 910, 125);
        if(g1 == true && g2 == true && g3 == true ){
            g.drawString("3", 980 , 125);
        }else if(g1== true && g2 ==true){
            g.drawString("2", 980 , 125);
        }else if(g1== true){
            g.drawString("1", 980, 125);
        }else{
            g.drawString("0", 980, 125);
        }
        repaint();
    }else{
        if(ba==1){
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 450, 450);
        }else if(ba==2){
            g.setColor(Color.BLUE);
            g.drawString("YOU WIN", 450, 450);
        }
            time.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        o -= 20;
        if(this.secuencia == 1){
            this.secuencia = 0;
        }else{
            this.secuencia++;
        }
        if(this.secuencias == 3){
            this.secuencias = 0;
        }else{
            this.secuencias++;
        }
        if(o<=700)
            o = ixc;
        repaint();
    }
    public NewPanel() {
        
        time = new Timer(1000, this);
        this.time.start();
        this.o = ixc;
        this.addMouseListener(this);
        addKeyListener(new TAdapter());
        setFocusable(true);
        
    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle (250-es, 655, 315-es, 714);
    }
    public Rectangle get1(){
        return new Rectangle (500-es, 655, 565-es, 714);
    }
    public Rectangle get2(){
        return new Rectangle (630-es, 655, 695-es, 714);
    }
    public Rectangle get3(){
        return new Rectangle (565-es, 600, 630-es, 655);
    }
    public Rectangle get4(){
        return new Rectangle (630-es, 600, 695-es, 655);
    }
    public Rectangle get5(){
        return new Rectangle (0-es, 716, 2000, 200);
    }
    public Rectangle get6(){
        return new Rectangle (250-es, 600, 55, 55);
    }
    public Rectangle get7(){
        return new Rectangle (500-es, 600, 55, 55);
    }
    public Rectangle get8(){
        return new Rectangle (635-es, 545, 55, 55);
    }
    public Rectangle getEne(){
        return new Rectangle(322-es, 625, 100, 100);
    }
    public Rectangle getEne1(){
        return new Rectangle(322-es, 625, 100, 100);
    }
    public Rectangle getWin(){
        return new Rectangle(1400-es, 615, 20, 100);
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        
        return image;
    }
    
    private class TAdapter extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e){
            up = 4;
            y -= 1;
            boolean fl = checkCollision();
        }
        @Override
        public void keyPressed(KeyEvent e){
            re = 0;
            boolean t = checkCollisions();
            boolean fl = checkCollision();
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_SPACE){
                System.out.println("Espacio");
            }
            if(key == KeyEvent.VK_UP){
                if(fl==false){
                    es += 1;
                }
                if(nub<-200){
                    up=4;
                }else{
                    nub -= 5;
                    y -= 5;
                    up=2;
                }
                re = 1;
                
            }
            if(key == KeyEvent.VK_RIGHT){
                if(t==false){
                    es += 1;
                }
                up = 1;
            }
            if(key == KeyEvent.VK_LEFT){
                es -=1;
                up = 1;
            }
        }
    }
}
