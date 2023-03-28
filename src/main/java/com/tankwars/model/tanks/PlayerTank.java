package com.tankwars.model.tanks;

import com.tankwars.model.buildings.Building;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 22:28
 * @PackageName:com.tankwars.model.tanks
 * @ClassName: Tank
 * @Description: TODO
 * @Version 1.0
 */
public class PlayerTank extends BaseTank {
    public int x;
    public int y;
    public int oldX, oldY;
    public final int height = 50;
    public final int width = 50;
    public int speed = 1;
    public int hp;
    public int blood;
    public int type;
    public int direction = 0;//8上 2下 4左 6右

    public String upImgUrl = "images/tankUp.png";
    public String downImgUrl = "images/tankDown.png";
    public String leftImgUrl = "images/tankLeft.png";
    public String rightImgUrl = "images/tankRight.png";
    public Image tankImg = new ImageIcon(upImgUrl).getImage();


    public PlayerTank(int x, int y, int type, int hp) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hp = hp;
    }

    public void upDateDirectionState(){
        switch (this.direction) {
            case 8://上
                tankImg = new ImageIcon(upImgUrl).getImage();
                break;
            case 2://下
                tankImg = new ImageIcon(downImgUrl).getImage();
                break;
            case 4://左
                tankImg = new ImageIcon(leftImgUrl).getImage();
                break;
            case 6://右
                tankImg = new ImageIcon(rightImgUrl).getImage();
                break;
        }
    }
    public void move() {
        this.oldX = this.x;
        this.oldY = this.y;
        switch (this.direction) {
            case 8://上
                tankImg = new ImageIcon(upImgUrl).getImage();
                this.y = this.y - this.speed;
                break;
            case 2://下
                tankImg = new ImageIcon(downImgUrl).getImage();
                this.y = this.y + this.speed;
                break;
            case 4://左
                tankImg = new ImageIcon(leftImgUrl).getImage();
                this.x = this.x - this.speed;
                break;
            case 6://右
                tankImg = new ImageIcon(rightImgUrl).getImage();
                this.x = this.x + this.speed;
                break;
        }
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y > 475) {
            this.y = 475;
        }
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > 500) {
            this.x = 500;
        }
    }

    public int getBlood() {
        return this.blood;
    }

    public void drawing(Graphics g) {
        g.drawImage(tankImg, this.x, this.y, this.width, this.height, null);
    }

    public Rectangle getRectangle() {
        switch (direction) {
            case 8:
                return new Rectangle(this.x, this.y - this.speed, this.width, this.height);
            case 2:
                return new Rectangle(this.x, this.y + this.speed, this.width, this.height);
            case 4:
                return new Rectangle(this.x - this.speed, this.y, this.width, this.height);
            case 6:
                return new Rectangle(this.x + this.speed, this.y, this.width, this.height);
            default:return new Rectangle(this.x , this.y, this.width, this.height);
        }
    }
}
