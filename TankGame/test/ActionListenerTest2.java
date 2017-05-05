package com.tankgame.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by kysft on 5/4/17.
 */
public class ActionListenerTest2 extends JFrame{
    MyPanel2 mp2=null;
    public static void main(String[] args){
        ActionListenerTest2 alt2=new ActionListenerTest2();
    }
    public ActionListenerTest2(){

        mp2=new MyPanel2();
        this.add(mp2);
        this.addMouseListener(mp2);
        this.addKeyListener(mp2);
        this.setSize(400,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel2 extends JPanel implements MouseListener, KeyListener{
    public void paint(Graphics g){
        super.paint(g);
    }
    //click
    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println("Click position: " + e.getX() +"and " + e.getY());
    }
    //press
    @Override
    public void mousePressed(MouseEvent e) {

    }
    //release
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    //move in
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    //move out
    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       System.out.println(e.getKeyChar() + " code is " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
