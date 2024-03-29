package com.tankwars.model.obstacles;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 10:42
 * @PackageName:com.tankwars.model
 * @ClassName: Wall
 * @Description: TODO
 * @Version 1.0
 */
public class Wall extends BaseObstacle {
    //1
    public final int width = 25;
    public final int height = 25;
    public int x;
    public int y;

    Image img = new ImageIcon("images/wall.png").getImage();

    public Wall(int x, int y) {
        super(x,y);
        this.x = x;
        this.y = y;
    }

    public void drawing(Graphics g) {
        g.drawImage(this.img, x, y, width, height, null);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", img=" + img +
                "} " + super.toString();
    }
}
