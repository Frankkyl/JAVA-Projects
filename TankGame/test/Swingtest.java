package com.tankgame.test;
import javax.swing.*;
import java.awt.*;

/**
 * Created by kysft on 5/3/17.
 * swing practice
 */
public class Swingtest extends JFrame{
    Mypanel mp=null;
    public static void main(String[] args){
        Swingtest test=new Swingtest();
    }
    public Swingtest(){
        mp=new Mypanel();

        this.add(mp);

        this.setSize(400,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//define mypanel
class Mypanel extends JPanel{
    //cover JPanel with ur "Pen"
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.drawOval(10,10,30,30);
        g.setColor(Color.green);
        g.fillRect(40,40,50,25);
        g.setColor(Color.black);
        g.drawRect(80,80,50,30);
        g.setColor(Color.BLUE);
        g.drawLine(150,150,250,150);

        //Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/wgs.JPG"));
        //g.drawImage(im,160,160,90,70,this);

        g.setColor(Color.DARK_GRAY);
        g.drawString("滚",300,300);

        g.setColor(Color.red);
        g.fillOval(50,300,40,70);
        g.setColor(Color.green);
        g.fillOval(47,310,8,16);
        g.fillOval(85,310,8,16);
        g.fillOval(47,350,8,16);
        g.fillOval(85,350,8,16);

        g.fillOval(65,285,8,25);
        g.fillOval(63,288,12,18);

        g.setColor(Color.black);
        g.fillOval(63,295,2,2);
        g.fillOval(71,295,2,2);

        g.setColor(Color.blue);
        g.drawArc(66,320,60,380,50,140);
    }
}
