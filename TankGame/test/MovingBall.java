package com.tankgame.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by kysft on 5/3/17.
 */
public class MovingBall extends JFrame{

    MyPanel mp=null;

    public MovingBall(){
        mp=new MyPanel();

        this.add(mp);

        this.addKeyListener(mp);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400,300);
        this.setVisible(true);
    }

    public static void main(String[] args){
        MovingBall mb=new MovingBall();
    }
class MyPanel extends JPanel implements KeyListener{
    int x=10;
    int y=10;
    public void paint(Graphics g){
        super.paint(g);

        g.fillOval(x,y,20,20);
    }

    @Override//print
    public void keyTyped(KeyEvent e) {

    }

    @Override//click
    public void keyPressed(KeyEvent e) {
        //System.out.println("click " + (char)e.getKeyCode());
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            y+=5;
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            x++;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            x--;
        }
        this.repaint();
    }

    @Override//release
    public void keyReleased(KeyEvent e) {

    }
}


}
