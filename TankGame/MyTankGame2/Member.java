package com.tankgame.TankGame2;

/**
 * Created by kysft on 5/4/17.
 */
public class Member {
}
class Tank2{
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
    public Tank2(int x, int y){
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

class Enemy2 extends Tank2{
   public Enemy2(int x,int y){
       super(x,y);
   }
}
class Hero2 extends Tank2 {
    public Hero2(int x,int y) {
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

