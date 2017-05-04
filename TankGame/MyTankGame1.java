package com.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

/**
 * Created by kysft on 5/3/17.
 */
public class MyTankGame1 extends JFrame {
    MyPanel mp=null;
    public static void main(String[] args){
        MyTankGame1 mtg=new MyTankGame1();
    }
    public MyTankGame1(){
        mp=new MyPanel();

        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel{
    Hero hero=null;
    public MyPanel(){
        hero=new Hero(70,70);
    }
    public void paint(Graphics g){
        super.paint(g);

        g.fillRect(0,0,400,300);
        this.drawTank(hero.getX(),hero.getY(),g,0,1);
    }
    public void drawTank(int x, int y, Graphics g, int direct, int type){

        switch(type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch(direct){
            case 0:
                g.fill3DRect(x,y,5,30,false);
                g.fill3DRect(x+5,y+5,10,20,false);
                g.fillOval(x+5,y+10,10,10);
                g.drawLine(x+10,y+15,x+10,y);
                g.fill3DRect(x+15,y,5,30,false);
                break;
        }
    }
}

class Tank{
    int x=0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int y=0;
    public Tank(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Hero extends Tank {
    public Hero(int x,int y) {
        super(x,y);
    }
}
