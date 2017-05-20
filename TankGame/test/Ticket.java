package com.tankgame.test;

/**
 * Created by kysft on 5/20/17.
 */
public class Ticket {
    public static void main(String[] args){
        //define three ticket windows
        TicketWindow tw1=new TicketWindow();
        Thread t1=new Thread(tw1);
        t1.start();
    }
}

class TicketWindow implements Runnable{

    private int nums=2000;

    public void run(){
        while(true){
            //synchronized=>blocked;
            synchronized(this) {
                if (nums > 0) {
                    System.out.println(Thread.currentThread().getName() + " This is the " + nums + " tickets.");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    nums--;
                } else {
                    break;
                }
            }
        }
    }
}
