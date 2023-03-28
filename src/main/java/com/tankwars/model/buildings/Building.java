package com.tankwars.model.buildings;

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
public class Building {
    public int width = 50;
    public int height = 50;
    public int x;
    public int y;
    public String name = "1";
    Image img = new ImageIcon("images/home.png").getImage();

    public Building(int x,int y){

    }

    public void drawing(Graphics g) {
        g.drawImage(this.img, x, y, width, height, null);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

}
