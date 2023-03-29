package com.tankwars.model.tanks;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 15:50
 * @PackageName:com.tankwars.model.tanks
 * @ClassName: Tank
 * @Description: TODO
 * @Version 1.0
 */
public class BaseTank {
    public int x;
    public int y;
    public final int height = 50;
    public final int width = 50;
    public int speed;
    public int hp;
    public int oldX, oldY;
    public int blood;
    public int type;
    public int direction;//8上 2下 4左 6右
    public Boolean upMove = false;
    public Boolean downMove = false;
    public Boolean leftMove = false;
    public Boolean rightMove = false;
    public Image tankImg = new ImageIcon().getImage();

    public void move() {
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


    public int getBlood() {
        return this.blood;
    }
    public Rectangle getRectangle() {

        return new Rectangle(this.x, this.y, this.width, this.height);
    }

}
