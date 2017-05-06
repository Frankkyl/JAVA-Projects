package com.tankgame.TankGame3;

/**
 * Created by kysft on 5/5/17.
 */

public class Member {
}
class Tank3{
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
    public Tank3(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    //up0,down1,left2,right3
    int direct=0;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    int speed=10;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    int type=1;

}

class Enemy3 extends Tank3 {
    public Enemy3(int x,int y){
        super(x,y);
    }
}
class Hero3 extends Tank3 {

    Shot shot=null;

    public void shotEnemy(){

        switch(this.direct){
            case 0:
                shot=new Shot(x,y-15,0);
                break;
            case 1:
                shot=new Shot(x+15,y,1);
                break;
            case 2:
                shot=new Shot(x,y+15,2);
                break;
            case 3:
                shot=new Shot(x-15,y,3);
                break;
        }
        Thread t=new Thread(shot);
        t.start();

    }
    public Hero3(int x,int y) {
        super(x,y);
    }
    public void moveUp(){
        y-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }
}

class Shot implements Runnable{
    int x;
    int y;
    int direct;
    int speed=3;
    public Shot(int x,int y, int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(50);
            }catch (Exception e){
            }
            switch(direct){

                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
            }
            System.out.println("test: " +x +" "+y);
            if(x>400 || y>300 || x<0 || y<0){
                //this.isLive=false;
                break;
            }
        }

    }
}


