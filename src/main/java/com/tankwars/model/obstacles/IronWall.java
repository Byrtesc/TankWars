package com.tankwars.model.obstacles;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 10:43
 * @PackageName:com.tankwars.model
 * @ClassName: IronWall
 * @Description: TODO
 * @Version 1.0
 */
public class IronWall extends BaseObstacle {
    public final int width = 25;
    public final int height = 25;
    public int x;
    public int y;
    Image img = new ImageIcon("images/ironWall.png").getImage();

    public IronWall(int x, int y) {
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
}
