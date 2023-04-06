package com.tankwars.model.obstacles;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/4/6 10:19
 * @PackageName:com.tankwars.model.obstacles
 * @ClassName: Road
 * @Description: TODO
 * @Version 1.0
 */
public class Road extends BaseObstacle{
    public int x;
    public int y;

    public Road(int x, int y) {
        super(x, y);
        this.x=x;
        this.y=y;
    }
}
