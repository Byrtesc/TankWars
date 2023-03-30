package com.tankwars.model;

import com.tankwars.controller.Controller;
import com.tankwars.model.buildings.Building;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 22:28
 * @PackageName:com.tankwars.model.tanks
 * @ClassName: Tank
 * @Description: TODO
 * @Version 1.0
 */
public class Tank {
    public int x;
    public int y;
    public int oldX, oldY;
    public final int height = 40;
    public final int width = 40;
    public int speed = 1;
    public int hp;
    public int blood;
    public int type;//1为玩家
    public int direction=8;//8上 2下 4左 6右

    public Boolean upMove = false;
    public Boolean downMove = false;
    public Boolean leftMove = false;
    public Boolean rightMove = false;

    public String upImgUrl = "images/tankUp.png";
    public String downImgUrl = "images/tankDown.png";
    public String leftImgUrl = "images/tankLeft.png";
    public String rightImgUrl = "images/tankRight.png";
    public Image tankImg = new ImageIcon(upImgUrl).getImage();
    Controller controller;

    public Tank(int x, int y, int type, int hp,Controller controller) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hp = hp;
        this.controller=controller;
    }

    public void attack() {
        controller.bullets.add(new Bullet(getTankHead().x,getTankHead().y,this.direction,controller,this.type));
    }

    public void ranAttack(){
        switch (new Random().nextInt(4)){
            case 0:controller.bullets.add(new Bullet(getTankHead().x,getTankHead().y,this.direction,controller,this.type));break;
            case 1:break;
            case 2:break;
            case 3:break;
        }
    }

    public Point getTankHead() {//获得炮台位置
        switch (direction) {
            case 8:
                return new Point(this.x + (this.width / 2)-5, this.y);
            case 2:
                return new Point((this.x + this.width / 2)-3, this.y + height);
            case 4:
                return new Point(this.x, (this.y + height / 2)-3);
            case 6:
                return new Point(this.x + this.width, (this.y + height / 2)-3);
        }
        return null;
    }

    public void upDateDirectionState() {//更新状态
        if (upMove) {
            tankImg = new ImageIcon(upImgUrl).getImage();
            direction=8;
        }
        else if (downMove) {
            tankImg = new ImageIcon(downImgUrl).getImage();
            direction=2;
        }
        else if (leftMove) {
            tankImg = new ImageIcon(leftImgUrl).getImage();
            direction=4;
        }
        else if (rightMove) {
            tankImg = new ImageIcon(rightImgUrl).getImage();
            direction=6;
        }
    }

    public void move() {//移动
        upDateDirectionState();
        this.oldX = this.x;
        this.oldY = this.y;
        if (upMove) this.y = this.y - this.speed;
        if (downMove) this.y = this.y + this.speed;
        if (leftMove) this.x = this.x - this.speed;
        if (rightMove) this.x = this.x + this.speed;
        if (this.y < 0) this.y = 0;
        if (this.y > 475) this.y = 475;
        if (this.x < 0) this.x = 0;
        if (this.x > 500) this.x = 500;
    }

    public void ranDirection() {//随机方向
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i) {
            case 0:
                this.upMove = true;
                this.downMove = false;
                this.leftMove = false;
                this.rightMove = false;
                break;
            case 1:
                this.upMove = false;
                this.downMove = true;
                this.leftMove = false;
                this.rightMove = false;
                break;
            case 2:
                this.upMove = false;
                this.downMove = false;
                this.leftMove = true;
                this.rightMove = false;
                break;
            case 3:
                this.rightMove = true;
                this.upMove = false;
                this.downMove = false;
                this.leftMove = false;
                break;
        }
    }



    //检测与墙碰撞
    public boolean checkCollisionWall(List<Building> walls) {
        for (Building wall : walls) {
            if (wall.getRectangle().intersects(this.getRectangle())) {
                if (!wall.getClass().getName().equals("com.tankwars.model.buildings.Woods")) {
                    if (type!=1){//玩家坦克不触发随机方向
                        ranDirection();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //检测坦克碰撞
    public boolean checkCollisionTank(List<Tank> tanks) {
        for (Tank tank : tanks) {
            if (this != tank) {
                if (tank.getRectangle().intersects(this.getRectangle())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getBlood() {
        return this.blood;
    }

    public void drawing(Graphics g) {
        g.drawImage(tankImg, this.x, this.y, this.width, this.height, null);
    }

    public Rectangle getRectangle() {
        if (upMove)
            return new Rectangle(this.x, this.y - this.speed, this.width, this.height);
        if (downMove)
            return new Rectangle(this.x, this.y + this.speed, this.width, this.height);
        if (leftMove)
            return new Rectangle(this.x - this.speed, this.y, this.width, this.height);
        if (rightMove)
            return new Rectangle(this.x + this.speed, this.y, this.width, this.height);

        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    public Rectangle getNormalRectangle() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

}

