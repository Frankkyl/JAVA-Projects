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

        this.setSize(800,600);
        this.setLocation(90,90);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel3 extends JPanel implements KeyListener, Runnable {
    Hero3 hero3=null;
    Vector<Enemy3> enemy3=new Vector<Enemy3>();
    int enSize=5;

    public MyPanel3(){
        hero3=new Hero3(400,500);
        hero3.setType(1);
        for(int i=0;i<enSize;i++){
            Enemy3 enemyTank=new Enemy3((i+1)*800/(enSize+1),80);
            enemyTank.setType(0);
            enemyTank.setDirect(2);
            enemy3.add(enemyTank);
        }
    }
    public void paint(Graphics g){
        super.paint(g);

        g.fillRect(0,0,800,600);
        this.drawTank(hero3.getX(),hero3.getY(),g,this.hero3.getDirect(),this.hero3.getType());

        if(hero3.shot!=null){
            g.setColor(Color.GREEN);
            switch(hero3.shot.direct){
                case 0:
                    g.fillRect(hero3.shot.x+7,hero3.shot.y-26,7,10);
                    g.fillOval(hero3.shot.x+7,hero3.shot.y-29,7,7);
                    break;
                case 1:
                    g.fillRect(hero3.shot.x+51,hero3.shot.y+16,10,7);
                    g.fillOval(hero3.shot.x+57,hero3.shot.y+16,7,7);
                    break;
                case 2:
                    g.fillRect(hero3.shot.x+7,hero3.shot.y+47,7,10);
                    g.fillOval(hero3.shot.x+7,hero3.shot.y+52,7,7);
                    break;
                case 3:
                    g.fillRect(hero3.shot.x-22,hero3.shot.y+16,10,7);
                    g.fillOval(hero3.shot.x-26,hero3.shot.y+16,7,7);
                    break;
            }

        }
        for(int i=0; i<enSize;i++){
            this.drawTank(enemy3.get(i).getX(),enemy3.get(i).getY(),g,enemy3.get(i).getDirect(),enemy3.get(i).getType());
        }
    }
    public void drawTank(int x, int y, Graphics g, int direct, int type){

        Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/5.JPG"));

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
                g.fill3DRect(x-23,y-15,15,60,false);
                g.fill3DRect(x+27,y-15,15,60,false);
                g.fill3DRect(x-8,y-8,36,48,false);
                g.fillOval(x-8,y-4,36,36);
                g.fillRect(x+6,y-26,8,18);
                g.fillRect(x+4,y-32,12,6);
                break;
            case 1:
                g.fill3DRect(x-11,y-14,60,15,false);
                g.fill3DRect(x-11,y+36,60,15,false);
                g.fill3DRect(x-4,y+1,48,36,false);
                g.fillOval(x,y,36,36);
                g.fillRect(x+44,y+16,18,8);
                g.fillRect(x+61,y+14,6,12);
                break;
            case 2:
                g.fill3DRect(x-23,y-15,15,60,false);
                g.fill3DRect(x+27,y-15,15,60,false);
                g.fill3DRect(x-8,y-8,36,48,false);
                g.fillOval(x-8,y-4,36,36);
                g.fillRect(x+6,y+40,8,18);
                g.fillRect(x+4,y+56,12,6);

                break;
            case 3:
                g.fill3DRect(x-11,y-14,60,15,false);
                g.fill3DRect(x-11,y+36,60,15,false);
                g.fill3DRect(x-4,y+1,48,36,false);
                g.fillOval(x+2,y,36,36);
                g.fillRect(x-22,y+16,18,8);
                g.fillRect(x-28,y+14,6,12);
                break;
        }
        if(type==1){
            switch(direct){
                case 0: case 2:
                    g.drawImage(im,x-8,y-8,36,48,this);
                    break;
                case 1:case 3:
                    g.drawImage(im,x+1,y-6,36,48,this);
                    break;
            }
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


