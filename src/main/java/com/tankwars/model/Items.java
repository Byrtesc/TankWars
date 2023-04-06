package com.tankwars.model;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/4/5 20:56
 * @PackageName:com.tankwars.model.prop
 * @ClassName: BaseProp
 * @Description: TODO
 * @Version 1.0
 */
public class Items {
    public final int width = 25;
    public final int height = 25;
    public int x;
    public int y;
    public int type;//0为铁堡垒 1为血包 2为加强弹
    Image img;

    Controller controller;

    public Items(int x, int y, int type,Controller controller) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.controller=controller;
        switch (type){
            case 0:
                img=new ImageIcon("images/ironWallItem.png").getImage();
                break;
            case 1:
                img=new ImageIcon("images/bloodPackItem.png").getImage();
                break;
            case 2:
                img=new ImageIcon("images/piercingBulletItem.png").getImage();
                break;
        }
    }

    public void drawing(Graphics g) {
        g.drawImage(this.img, x, y, width, height, null);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void getBuff(List<Tank> tanks){
        for (Tank tank:tanks){
            if (tank.getRectangle().intersects(this.getRectangle())){
                System.out.println("与道具相撞:"+this.type);
                switch (this.type){
                    case 0://铁堡垒效果
                        controller.walls.removeAll(controller.homeNormalWalls);
                        controller.walls.addAll(controller.homeIronWalls);
                        controller.ironHomeWallBuff=true;
                        break;
                    case 1://血包
                        if (tank.hp<=3){
                            tank.hp++;
                        }
                        break;
                    case 2://穿甲弹
                        controller.playerTankPowerBuff=true;
                        tank.power=1;
                        break;
                }
                controller.removeItems.add(this);
            }
        }
    }
}
