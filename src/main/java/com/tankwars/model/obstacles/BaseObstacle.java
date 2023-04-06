package com.tankwars.model.obstacles;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 14:52
 * @PackageName:com.tankwars.model
 * @ClassName: Building
 * @Description: TODO
 * @Version 1.0
 */
public class BaseObstacle {
    public int width = 50;
    public int height = 50;
    public int x;
    public int y;
    public String name = "";
    Image img ;

    public BaseObstacle(int x, int y) {
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
        return "BaseObstacle{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                ", img=" + img +
                '}';
    }
}
