package com.tankgame.TankGame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * Created by kysft on 5/5/17.
 */

public class MyTankGame3 extends JFrame {
    MyPanel3 mp3=null;

    public static void main(String[] args){
        MyTankGame3 mtg3=new MyTankGame3();
    }
    public MyTankGame3(){
        mp3=new MyPanel3();
        Thread t=new Thread(mp3);
        t.start();
        this.add(mp3);
        this.addKeyListener(mp3);

        this.setSize(400,300);
        this.setLocation(90,90);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel3 extends JPanel implements KeyListener, Runnable {
    Hero3 hero3=null;
    Vector<Enemy3> enemy3=new Vector<Enemy3>();
    int enSize=3;

    public MyPanel3(){
        hero3=new Hero3(200,250);
        hero3.setType(1);
        for(int i=0;i<enSize;i++){
            Enemy3 enemyTank=new Enemy3((i+1)*400/(enSize+1),40);
            enemyTank.setType(0);
            enemyTank.setDirect(2);
            enemy3.add(enemyTank);
        }
    }
    public void paint(Graphics g){
        super.paint(g);

        g.fillRect(0,0,400,300);
        this.drawTank(hero3.getX(),hero3.getY(),g,this.hero3.getDirect(),this.hero3.getType());

        if(hero3.shot!=null){
            g.drawRect(hero3.shot.x,hero3.shot.y,1,1);
        }
        for(int i=0; i<enSize;i++){
            this.drawTank(enemy3.get(i).getX(),enemy3.get(i).getY(),g,enemy3.get(i).getDirect(),enemy3.get(i).getType());
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
            this.hero3.setDirect(0);
            this.hero3.moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            this.hero3.setDirect(1);
            this.hero3.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            this.hero3.setDirect(2);
            this.hero3.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            this.hero3.setDirect(3);
            this.hero3.moveLeft();
        }

        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            this.hero3.shotEnemy();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            this.repaint();

        }
    }
}



