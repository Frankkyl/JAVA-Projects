package com.tankgame.test;

import javax.swing.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kysft on 5/3/17.
 */
public class ActionListenerTest extends JFrame implements ActionListener{

    MyPanel mp=null;
    JButton jb1=null;
    JButton jb2=null;
    public static void main(String[] args){
        ActionListenerTest alt=new ActionListenerTest();
    }
    public ActionListenerTest(){
        mp=new MyPanel();
        jb1=new JButton("BLACK");
        jb2=new JButton("RED");

        this.add(jb1,BorderLayout.NORTH);
        this.add(jb2,BorderLayout.SOUTH);
        this.add(mp);

        Cat myCat1=new Cat();

        jb1.addActionListener(this);
        jb1.addActionListener(myCat1);
        jb1.setActionCommand("jbB");


        jb2.addActionListener(this);
        jb2.addActionListener(myCat1);
        jb2.setActionCommand("jbR");

        this.setSize(300,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("jbB")){
            mp.setBackground(Color.BLACK);
        }else if(e.getActionCommand().equals("jbR")){
            mp.setBackground(Color.RED);
        }else{
            //never run here...
        }
    }
}

class Cat implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getActionCommand().equals("jbB")){
            System.out.println("Cat knows u clicked jb1");
        }else{
            System.out.println("Cat knows u clicked jb2");
        }
    }
}
class MyPanel extends JPanel{
    public void paint(Graphics g){
        super.paint(g);

        //g.fillRect(0,0,300,200);

    }
}
