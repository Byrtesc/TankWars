package com.tankwars.model;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/4/3 9:05
 * @PackageName:com.tankwars.model
 * @ClassName: Boom
 * @Description: TODO
 * @Version 1.0
 */
public class Boom {
    public int x;
    public int y;
    Image image[] = {
            new ImageIcon("images/boom.png").getImage(),
            new ImageIcon("images/boom2.png").getImage(),
            new ImageIcon("images/boom3.png").getImage(),
    };

    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawImages(Graphics g) {
//        for (int i=0;i<image.length;i++){
//            g.drawImage(new ImageIcon("images/tankboom/tankboom"+i+".png").getImage(),x,y,60,60,null);
//        }
        g.drawImage(new ImageIcon("images/boom.gif").getImage(), x, y, 50, 50, null);

    }

}
