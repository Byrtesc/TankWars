package com.tankwars.model;

import com.tankwars.controller.Controller;
import com.tankwars.model.buildings.Building;

import javax.swing.*;
import java.awt.*;
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
    public int direction;//8上 2下 4左 6右
    public Image bullet = new ImageIcon("images/bullet.png").getImage();
    public Controller controller;

    public Bullet(int x, int y, int direction, Controller controller){
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.controller=controller;
    }

    public void hitTank(List<Tank> tanks){
        for (Tank tank:tanks) {
            if (this.getRectangle().intersects(tank.getNormalRectangle())){
                System.out.println("子弹碰撞坦克");
                controller.removeBullets.add(this);
                controller.enemyTanks.remove(tank);
                System.out.println("删除");
                break;
            }
        }
    }

    public void hitBuilding(List<Building> buildings){
        for (Building building:buildings) {
            if (this.getRectangle().intersects(building.getRectangle())){
                System.out.println(building.getClass().getName());
                if (building.getClass().getName().equals("com.tankwars.model.buildings.IronWall")){
                    controller.removeBullets.add(this);
                }
                if (building.getClass().getName().equals("com.tankwars.model.buildings.Wall")){
                    controller.removeBullets.add(this);
                    controller.walls.remove(building);
                }
                break;
            }
        }
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
