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
    public int blood;
    public int type;
    public int direction;//8上 2下 4左 6右
    public Image tankImg = new ImageIcon().getImage();

    public void move(int direction) {
    }


    public int getBlood() {
        return this.blood;
    }
    public Rectangle getRectangle() {

        return new Rectangle(this.x, this.y, this.width, this.height);
    }
}
