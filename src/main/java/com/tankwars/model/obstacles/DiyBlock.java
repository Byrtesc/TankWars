package com.tankwars.model.obstacles;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/4/10 9:48
 * @PackageName:com.tankwars.model.obstacles
 * @ClassName: diyBlock
 * @Description: TODO
 * @Version 1.0
 */
public class DiyBlock extends BaseObstacle {
    public final int width = 25;
    public final int height = 25;
    public int x;
    public int y;
    public int block;
    Controller controller;
    Image image = new ImageIcon("images/diy/block.png").getImage();

    public DiyBlock(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    public DiyBlock(int x, int y, Controller controller) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.controller = controller;
    }

    public void drawing(Graphics g) {
        g.drawImage(this.image, x, y, width, height, null);
        g.drawImage(new ImageIcon("images/diy/block.png").getImage(), x, y, width, height, null);
    }

    public void move(int direction) {
        switch (direction) {
            case 8:
                this.y = this.y - 25;
                break;
            case 2:
                this.y = this.y + 25;
                break;
            case 4:
                this.x = this.x - 25;
                break;
            case 6:
                this.x = this.x + 25;
                break;
        }
        if (this.x - 25 < 0) this.x = 0;
        if (this.y - 25 < 0) this.y = 0;
        if (this.x + 25 > 525) this.x = 525;
        if (this.y + 25 > 500) this.y = 500;
        System.out.println("x:" + this.x + " y:" + this.y);
    }

    /**
     * 1 砖墙 2铁墙 3河流 4草丛
     *
     * @param
     */
    public void putBlock() {
        for (BaseObstacle obstacle : controller.diyMapObstacleList) {
            Rectangle tmpRect = new Rectangle(this.x, this.y, width, height);
            if (obstacle.getRectangle().intersects(tmpRect)) {
                int result = JOptionPane.showConfirmDialog(null, "当前位置已有障碍物，是否覆盖?", "障碍物冲突!", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION||result == JOptionPane.CLOSED_OPTION) {
                    return;
                }else {
                    controller.diyMapObstacleList.remove(obstacle);
                    putBlocks();
                }
            }
        }
        putBlocks();
    }

    public void putBlocks(){
        switch (this.block) {
            case 1:
                controller.diyMapObstacleList.add(new Wall(this.x, this.y));
                break;
            case 2:
                controller.diyMapObstacleList.add(new IronWall(this.x, this.y));
                break;
            case 3:
                controller.diyMapObstacleList.add(new River(this.x, this.y));
                break;
            case 4:
                controller.diyMapObstacleList.add(new Woods(this.x, this.y));
                break;
        }
    }
    public void updateBlock(int block) {
        this.block = block;
        switch (block) {
            case 1:
                this.image = new ImageIcon("images/wall.png").getImage();
                break;
            case 2:
                this.image = new ImageIcon("images/ironWall.png").getImage();
                break;
            case 3:
                this.image = new ImageIcon("images/river.png").getImage();
                break;
            case 4:
                this.image = new ImageIcon("images/woods.png").getImage();
                break;
        }
    }
}
