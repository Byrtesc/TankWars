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
        this.controller=controller;
    }

    public void drawing(Graphics g) {
        g.drawImage(this.image, x, y, width, height, null);
    }

    public void move(int direction) {
        switch (direction) {
            case 8:
                this.x = this.x - 25;
                break;
            case 2:
                this.x = this.x + 25;
                break;
            case 4:
                this.y = this.x - 25;
                break;
            case 6:
                this.y = this.x + 25;
                break;
        }
    }

    /**
     * 1 砖墙 2铁墙 3河流 4草丛
     * @param
     */
    public void putBlock() {
        switch (this.block){
            case 1:
                controller.diyMapObstacleList.add(new Wall(this.x,this.y));
                break;
            case 2:
                controller.diyMapObstacleList.add(new IronWall(this.x,this.y));
                break;
            case 3:
                controller.diyMapObstacleList.add(new River(this.x,this.y));
                break;
            case 4:
                controller.diyMapObstacleList.add(new Woods(this.x,this.y));
                break;
        }
    }

    public void updateBloc(int block){
        this.block=block;
        switch (block){
            case 1:
                this.image=new ImageIcon("images/wall.png").getImage();
                break;
            case 2:
                new ImageIcon("images/ironWall.png").getImage();
                break;
            case 3:
                this.image=new ImageIcon("images/river.png").getImage();
                break;
            case 4:
                this.image=new ImageIcon("images/woods.png").getImage();
                break;
        }
    }
}
