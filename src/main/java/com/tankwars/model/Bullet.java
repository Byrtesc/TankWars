package com.tankwars.model;

import com.tankwars.controller.Controller;
import com.tankwars.model.obstacle.BaseObstacle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/3/30 9:57
 * @PackageName:com.tankwars.model
 * @ClassName: Bullet
 * @Description: TODO
 * @Version 1.0
 */
public class Bullet {
    public int x;
    public int y;
    public int tankType;
    public int direction;//8上 2下 4左 6右
    public Image bullet = new ImageIcon("images/bullet.png").getImage();
    public Controller controller;

    public Bullet(int x, int y, int direction, Controller controller,int type){
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.controller=controller;
        this.tankType=type;
    }

    public void hitTank(List<Tank> tanks){
        for (Tank tank:tanks) {
            if (this.getRectangle().intersects(tank.getNormalRectangle())){
                if (this.tankType!=tank.type) {
                    System.out.println("子弹碰撞坦克");
                    controller.boomList.add(new Boom(tank.x,tank.y));
                    controller.removeBullets.add(this);
                    controller.enemyTanks.remove(tank);
                    //不可以在这里删除，打中添加到数组到外面删除
                    controller.playerTanks.remove(tank);
                    System.out.println("删除");
                }
                break;
            }
        }
    }

    public void hitBuilding(List<BaseObstacle> baseObstacles){
        List<BaseObstacle> baseObstacleTemp =new ArrayList<>();
        for (BaseObstacle baseObstacle : baseObstacles) {
            if (this.getRectangle().intersects(baseObstacle.getRectangle())){
                if (baseObstacle.getClass().getName().equals("com.tankwars.model.obstacle.IronWall")){
                    controller.removeBullets.add(this);
                }
                if (baseObstacle.getClass().getName().equals("com.tankwars.model.obstacle.Wall")){
                    controller.removeBullets.add(this);
                    baseObstacleTemp.add(baseObstacle);
                }
            }
        }
        controller.walls.removeAll(baseObstacleTemp);
    }

    public void hitPlayer(){

    }
    public void drawing(Graphics g) {
        g.drawImage(bullet, this.x, this.y, 10, 10, null);
    }

    public void move() {
        if (direction==8) this.y = this.y - 10;
        if (direction==2) this.y = this.y + 10;
        if (direction==4) this.x = this.x - 10;
        if (direction==6) this.x = this.x + 10;
        if (this.y < 0||this.y > 510||this.x < 0||this.x > 510)  controller.removeBullets.add(this);
    }

    public Rectangle getRectangle(){
        return new Rectangle(this.x,this.y,10,10);
    }

}
