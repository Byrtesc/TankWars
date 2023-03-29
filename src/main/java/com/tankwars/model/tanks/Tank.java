package com.tankwars.model.tanks;

import com.tankwars.model.buildings.Building;
import com.tankwars.model.buildings.Wall;

import javax.swing.*;
import java.awt.*;
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
public class Tank extends BaseTank {
    public int x;
    public int y;
    public int oldX, oldY;
    public final int height = 50;
    public final int width = 50;
    public int speed = 1;
    public int hp;
    public int blood;
    public int type;
    public int direction ;//8上 2下 4左 6右

    public Boolean upMove = false;
    public Boolean downMove = false;
    public Boolean leftMove = false;
    public Boolean rightMove = false;

    public String upImgUrl = "images/tankUp.png";
    public String downImgUrl = "images/tankDown.png";
    public String leftImgUrl = "images/tankLeft.png";
    public String rightImgUrl = "images/tankRight.png";
    public Image tankImg = new ImageIcon(upImgUrl).getImage();


    public Tank(int x, int y, int type, int hp) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hp = hp;
    }


    public void upDateDirectionState() {//更新状态
        if (upMove) tankImg = new ImageIcon(upImgUrl).getImage();
        if (downMove) tankImg = new ImageIcon(downImgUrl).getImage();
        if (leftMove) tankImg = new ImageIcon(leftImgUrl).getImage();
        if (rightMove) tankImg = new ImageIcon(rightImgUrl).getImage();
    }

    public void move() {
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

    public void ranDirection() {
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

    public void moveStop() {//坦克停止
        this.upMove = false;
        this.downMove = false;
        this.leftMove = false;
        this.rightMove = false;
    }

    //检测与墙碰撞
    public boolean checkCollisionWall(List<Building> walls) {
        for (Building wall : walls) {
            if (wall.getRectangle().intersects(this.getRectangle())) {
                if (!wall.getClass().getName().equals("com.tankwars.model.buildings.Woods")) {
                    System.out.println("发生碰撞");
                    return true;
                }
            }
        }
        return false;
    }

    //检测坦克碰撞
    public boolean checkCollisionTank(List<Tank> tanks) {
        for (Tank tank : tanks) {
            if (this!=tank){
                if (tank.getRectangle().intersects(this.getRectangle())) {
                    System.out.println("发生碰撞");
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
//        switch (direction) {
//            case 8:
//                return new Rectangle(this.x, this.y - this.speed, this.width, this.height);
//            case 2:
//                return new Rectangle(this.x, this.y + this.speed, this.width, this.height);
//            case 4:
//                return new Rectangle(this.x - this.speed, this.y, this.width, this.height);
//            case 6:
//                return new Rectangle(this.x + this.speed, this.y, this.width, this.height);
//            default:
//                return new Rectangle(this.x, this.y, this.width, this.height);
//        }
    }
}

