package com.tankwars.model;

import com.tankwars.controller.Controller;
import com.tankwars.model.obstacles.BaseObstacle;
import com.tankwars.model.obstacles.Road;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/3/30 9:57
 * @PackageName:com.tankwars.model
 * @ClassName: Bullet
 * @Description: TODO
 * @Version 1.0
 */
public class Bullet {
    public int x;
    public int y;
    public int tankType;
    public int power;//0为普通 1为穿甲
    public int direction;//8上 2下 4左 6右
    public Image bullet = new ImageIcon("images/bullet.png").getImage();
    public Controller controller;

    public Bullet(int x, int y, int direction,int type, int power,Controller controller){
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.controller=controller;
        this.tankType=type;
        this.power=power;
        switch (power){
            case 0:
                bullet = new ImageIcon("images/bullet.png").getImage();
                break;
            case 1:
                bullet = new ImageIcon("images/piercingBullet.png").getImage();
                break;
        }
    }

    public void hitTank(List<Tank> tanks){
        for (Tank tank:tanks) {
            if (this.getRectangle().intersects(tank.getNormalRectangle())){
                if (this.tankType!=tank.type) {

                    controller.musicUtil.boomMusic();
                    controller.boomList.add(new Boom(tank.x,tank.y));

                    controller.removeBullets.add(this);

                    //不可以在这里删除，打中添加到数组到外面删除
                    if (--tank.blood==0&&tank.type==1){
                        if (--controller.playerTankHp==0){
                            controller.playerTanks.remove(tank);
                        }else {
                            tank.x=90;
                            tank.y=475;
                            tank.blood=3;
                        }
                    }


                    if (tank.blood<=0){
                        switch (tank.color){
                            case "white":
                                controller.nowWhiteTankNum--;
                                controller.whiteTankNum++;
                                controller.nowScore+=100;
                                controller.allScore+=100;
                                break;
                            case "yellow":
                                controller.nowYellowTankNum--;
                                controller.yellowTankNum++;
                                controller.nowScore+=200;
                                controller.allScore+=200;
                                break;
                            case "green":
                                controller.nowGreenTankNum--;
                                controller.greenTankNum++;
                                controller.nowScore+=200;
                                controller.allScore+=200;
                                break;
                            case "blue":
                                controller.nowBlueTankNum--;
                                controller.blueTankNum++;
                                controller.nowScore+=300;
                                controller.allScore+=300;
                                break;
                            case "red":
                                controller.nowRedTankNum--;
                                controller.redTankNum++;
                                controller.nowScore+=500;
                                controller.allScore+=500;
                                break;
                        }
                        controller.nowDesTankNum++;
                        controller.allDesTankNum++;
                        controller.enemyTanks.remove(tank);
                    }
//                    controller.playerTanks.remove(tank);

                }
                break;
            }
        }
    }

    public void hitBuilding(List<BaseObstacle> baseObstacles){
        List<BaseObstacle> baseObstacleTemp =new ArrayList<>();
        for (BaseObstacle baseObstacle : baseObstacles) {
            if (this.getRectangle().intersects(baseObstacle.getRectangle())){
                if (baseObstacle.getClass().getName().equals("com.tankwars.model.obstacles.IronWall")){
                    controller.removeBullets.add(this);
                }
                if (baseObstacle.getClass().getName().equals("com.tankwars.model.obstacles.Wall")){
                    controller.boomList.add(new Boom(baseObstacle.x-10,baseObstacle.y-8));
                    controller.roads.add(new Road(baseObstacle.x,baseObstacle.y));
                    controller.removeBullets.add(this);
                    baseObstacleTemp.add(baseObstacle);
                }
            }
        }
        controller.walls.removeAll(baseObstacleTemp);
    }

    public void hitBullet(List<Bullet>  bullets){
        for (Bullet bullet: bullets){
            if (this!=bullet){
                if (this.getRectangle().intersects(bullet.getRectangle())){
                    controller.removeBullets.add(this);
                    controller.removeBullets.add(bullet);
                }
            }
        }
    }

    public void drawing(Graphics g) {
        g.drawImage(bullet, this.x, this.y, 10, 10, null);
    }

    public void move() {
        if (direction==8) this.y = this.y - 10;
        if (direction==2) this.y = this.y + 10;
        if (direction==4) this.x = this.x - 10;
        if (direction==6) this.x = this.x + 10;
        if (this.y < 0||this.y > 550||this.x < 0||this.x > 550)  controller.removeBullets.add(this);
    }

    public Rectangle getRectangle(){
        return new Rectangle(this.x,this.y,10,10);
    }

}
