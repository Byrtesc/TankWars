package com.tankwars.model.buildings;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 10:44
 * @PackageName:com.tankwars.model
 * @ClassName: Woods
 * @Description: TODO
 * @Version 1.0
 */
public class Woods extends Building {
    public final int width = 25;
    public final int height = 25;
    public int x;
    public int y;


    Image img = new ImageIcon("images/woods.png").getImage();

    public Woods(int x, int y) {
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
