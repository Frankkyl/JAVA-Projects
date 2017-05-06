package com.tankgame.test;


/**
 * Created by kysft on 5/5/17.
 */
public class MulThread {
    public static void main(String[] args){
        //CatMT catmt=new CatMT();
        //catmt.start();
        CatMT2 catmt2=new CatMT2();
        Thread td=new Thread(catmt2);
        td.start();
        Bird bird=new Bird(7);
        Thread tdb=new Thread(bird);
        tdb.start();
    }
}
class CatMT extends Thread{
    int times=0;
    public void run(){
        while(times<10){//run 10 times
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times++;
            System.out.println("hello, world!" +times);
        }
    }
}
class CatMT2 implements Runnable{
    int times=0;
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            times++;
            System.out.println("hello, world!2 " +times);
            if(times==10){
                break;
            }
        }
    }
}
class Bird implements Runnable{
    int n=0;
    int res=0;
    int times=0;
    public Bird(int n){
        this.n=n;
    }
    public void run(){
        while(res<n){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res=(++times);
            System.out.println("CURRENT res: "+res);
        }
        System.out.println("Now res is: " +res + ", and n is: " +n);
    }
}
