
package com.tankgame.TankGame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Created by kysft on 5/4/17.
 */
public class MyTankGame2 extends JFrame {
    MyPanel2 mp2=null;

    public static void main(String[] args){
        MyTankGame2 mtg=new MyTankGame2();
    }
    public MyTankGame2(){
        mp2=new MyPanel2();

        this.add(mp2);
        this.addKeyListener(mp2);

        this.setSize(400,300);
        this.setLocation(90,90);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel2 extends JPanel implements KeyListener {
    Hero2 hero2=null;
    Vector<Enemy2> enemy2=new Vector<Enemy2>();
    int enSize=3;


    public MyPanel2(){
        hero2=new Hero2(200,250);
        hero2.setType(1);
        for(int i=0;i<enSize;i++){
           Enemy2 enemyTank=new Enemy2((i+1)*400/(enSize+1),40);
           enemyTank.setType(0);
           enemyTank.setDirect(2);
           enemy2.add(enemyTank);
        }
    }
    public void paint(Graphics g){
        super.paint(g);

        g.fillRect(0,0,400,300);
        this.drawTank(hero2.getX(),hero2.getY(),g,this.hero2.getDirect(),this.hero2.getType());
        for(int i=0; i<enSize;i++){
            this.drawTank(enemy2.get(i).getX(),enemy2.get(i).getY(),g,enemy2.get(i).getDirect(),enemy2.get(i).getType());
        }
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
                g.fill3DRect(x-11,y-15,5,30,false);
                g.fill3DRect(x+6,y-15,5,30,false);
                g.fill3DRect(x-6,y-10,12,20,false);
                g.fillOval(x-6,y-6,12,12);
                g.drawLine(x,y,x,y-15);
                break;
            case 1:
                g.fill3DRect(x-11,y-11,30,5,false);
                g.fill3DRect(x-11,y+6,30,5,false);
                g.fill3DRect(x-6,y-6,20,12,false);
                g.fillOval(x-3,y-6,12,12);
                g.drawLine(x+3,y,x+18,y);
                break;
            case 2:
                g.fill3DRect(x-11,y-15,5,30,false);
                g.fill3DRect(x+6,y-15,5,30,false);
                g.fill3DRect(x-6,y-10,12,20,false);
                g.fillOval(x-6,y-6,12,12);
                g.drawLine(x,y,x,y+15);
                break;
            case 3:
                g.fill3DRect(x-11,y-11,30,5,false);
                g.fill3DRect(x-11,y+6,30,5,false);
                g.fill3DRect(x-6,y-6,20,12,false);
                g.fillOval(x-3,y-6,12,12);
                g.drawLine(x,y,x-12,y);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            this.hero2.setDirect(0);
            this.hero2.moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            this.hero2.setDirect(1);
            this.hero2.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            this.hero2.setDirect(2);
            this.hero2.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            this.hero2.setDirect(3);
            this.hero2.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

