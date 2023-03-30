package com.tankwars.model.buildings;

import com.tankwars.model.tanks.Tank;

import java.awt.*;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/3/29 16:14
 * @PackageName:com.tankwars.model.buildings
 * @ClassName: BirthPoint
 * @Description: TODO
 * @Version 1.0
 */
public class BirthPoint extends Building {
    public final int width = 50;
    public final int height = 50;
    public int x;
    public int y;

    public BirthPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkEmpty(List<Tank> tanks) {//为否的时候为非空，为true为空
        for (Tank tank:tanks){
            if (this.getRectangle().intersects(tank.getRectangle())) {
                return false;
            }
        }
        return true;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }
}