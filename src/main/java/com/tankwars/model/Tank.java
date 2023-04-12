package com.tankwars.model;

import com.tankwars.ai.Node;
import com.tankwars.controller.Controller;
import com.tankwars.model.obstacles.BaseObstacle;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 22:28
 * @PackageName:com.tankwars.model.tanks
 * @ClassName: Tank
 * @Description: TODO
 * @Version 1.0
 */
public class Tank {
    public int x;
    public int y;
    public final int height = 25;
    public final int width = 25;
    public int speed = 3;
    public int hp;//生命值指重生次数
    public int blood = 3;//一条命得血量
    public int bloodLimit=3;//一条命得血量上线
    public int type;//1为玩家
    public int direction = 8;//8上 2下 4左 6右

    public Boolean upMove = false;
    public Boolean downMove = false;
    public Boolean leftMove = false;
    public Boolean rightMove = false;

    public String upImgUrl;
    public String downImgUrl;
    public String leftImgUrl;
    public String rightImgUrl;
    public Image tankImg;

    public String color;
    Controller controller;
    public int power = 0;

    public Tank(int x, int y, int type, int hp, int speed, String color, Controller controller) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hp = hp;
        this.speed = speed;
        this.controller = controller;
        this.color = color;
        switch (color) {
            case "blue":
                upImgUrl = "images/blue/bu.png";
                downImgUrl = "images/blue/bd.png";
                leftImgUrl = "images/blue/bl.png";
                rightImgUrl = "images/blue/br.png";
                break;
            case "white":
                upImgUrl = "images/gray/gu.png";
                downImgUrl = "images/gray/gd.png";
                leftImgUrl = "images/gray/gl.png";
                rightImgUrl = "images/gray/gr.png";
                break;
            case "green":
                upImgUrl = "images/green/gu.png";
                downImgUrl = "images/green/gd.png";
                leftImgUrl = "images/green/gl.png";
                rightImgUrl = "images/green/gr.png";
                break;
            case "red":
                upImgUrl = "images/red/ru.png";
                downImgUrl = "images/red/rd.png";
                leftImgUrl = "images/red/rl.png";
                rightImgUrl = "images/red/rr.png";
                break;
            case "yellow":
                upImgUrl = "images/yellow/yu.png";
                downImgUrl = "images/yellow/yd.png";
                leftImgUrl = "images/yellow/yl.png";
                rightImgUrl = "images/yellow/yr.png";
                break;
            default:
                upImgUrl = "images/tankUp.png";
                downImgUrl = "images/tankDown.png";
                leftImgUrl = "images/tankLeft.png";
                rightImgUrl = "images/tankRight.png";
                break;
        }
        upDateDirectionState();
    }

    public Tank(int x, int y, int type, int speed, String color, int blood,Controller controller) {
        this.blood=blood;
        this.x = x;
        this.y = y;
        this.type = type;
        this.hp = hp;
        this.bloodLimit=blood;
        this.speed = speed;
        this.controller = controller;
        this.color = color;
        switch (color) {
            case "blue":
                upImgUrl = "images/blue/bu.png";
                downImgUrl = "images/blue/bd.png";
                leftImgUrl = "images/blue/bl.png";
                rightImgUrl = "images/blue/br.png";
                break;
            case "white":
                upImgUrl = "images/gray/gu.png";
                downImgUrl = "images/gray/gd.png";
                leftImgUrl = "images/gray/gl.png";
                rightImgUrl = "images/gray/gr.png";
                break;
            case "green":
                upImgUrl = "images/green/gu.png";
                downImgUrl = "images/green/gd.png";
                leftImgUrl = "images/green/gl.png";
                rightImgUrl = "images/green/gr.png";
                break;
            case "red":
                upImgUrl = "images/red/ru.png";
                downImgUrl = "images/red/rd.png";
                leftImgUrl = "images/red/rl.png";
                rightImgUrl = "images/red/rr.png";
                break;
            case "yellow":
                upImgUrl = "images/yellow/yu.png";
                downImgUrl = "images/yellow/yd.png";
                leftImgUrl = "images/yellow/yl.png";
                rightImgUrl = "images/yellow/yr.png";
                break;
            default:
                upImgUrl = "images/tankUp.png";
                downImgUrl = "images/tankDown.png";
                leftImgUrl = "images/tankLeft.png";
                rightImgUrl = "images/tankRight.png";
                break;
        }
        upDateDirectionState();
    }

    public void attack() {
        controller.bullets.add(new Bullet(getTankHead().x, getTankHead().y, this.direction, this.type, this.power, controller));
        controller.musicUtil.fire();
    }

    public void ranAttack() {
        switch (new Random().nextInt(4)) {
            case 0:
                controller.bullets.add(new Bullet(getTankHead().x, getTankHead().y, this.direction, this.type, 0, controller));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                controller.bullets.add(new Bullet(getTankHead().x, getTankHead().y, this.direction, this.type, 0, controller));
                break;
        }
    }

    public Point getTankHead() {//获得炮台位置
        switch (direction) {
            case 8:
                return new Point(this.x + (this.width / 2) - 5, this.y);
            case 2:
                return new Point((this.x + this.width / 2) - 3, this.y + height);
            case 4:
                return new Point(this.x, (this.y + height / 2) - 3);
            case 6:
                return new Point(this.x + this.width, (this.y + height / 2) - 3);
        }
        return null;
    }

    public void upDateDirectionState() {//更新状态
        if (direction == 8) {
            tankImg = new ImageIcon(upImgUrl).getImage();
        } else if (direction == 2) {
            tankImg = new ImageIcon(downImgUrl).getImage();
        } else if (direction == 4) {
            tankImg = new ImageIcon(leftImgUrl).getImage();
        } else if (direction == 6) {
            tankImg = new ImageIcon(rightImgUrl).getImage();
        }

        if (upMove) {
            tankImg = new ImageIcon(upImgUrl).getImage();
            direction = 8;
        } else if (downMove) {
            tankImg = new ImageIcon(downImgUrl).getImage();
            direction = 2;
        } else if (leftMove) {
            tankImg = new ImageIcon(leftImgUrl).getImage();
            direction = 4;
        } else if (rightMove) {
            tankImg = new ImageIcon(rightImgUrl).getImage();
            direction = 6;
        }
    }

    public void move() {//移动
        upDateDirectionState();
        if (upMove) this.y = this.y - this.speed;
        if (downMove) this.y = this.y + this.speed;
        if (leftMove) this.x = this.x - this.speed;
        if (rightMove) this.x = this.x + this.speed;
        if (this.y < 0) this.y = 0;
        if (this.y > 490) this.y = 490;
        if (this.x < 0) this.x = 0;
        if (this.x > 510) this.x = 510;
    }

    public void moveToNodeList() {
        controller.movePath.clear();
        controller.awf.updateObstacles(controller.walls);
        for (int i=controller.awf.getWayLine(controller.playerTank1, this).size() - 4; i > 0; i--){
            Node tmpNode=controller.awf.getWayLine(controller.playerTank1, this).get(i);
            System.out.println("节点目标"+tmpNode.x + " " + tmpNode.y);
            controller.movePath.add(new Point(tmpNode.x*25,tmpNode.y*25));
        }
    }


    public void ranDirection() {//随机方向
        Random random = new Random();
        int i = random.nextInt(4);
        switch (i) {
            case 0:
                this.upMove = true;
                this.downMove = false;
                this.leftMove = false;
                this.rightMove = false;
                break;
            case 1:
                this.upMove = false;
                this.downMove = true;
                this.leftMove = false;
                this.rightMove = false;
                break;
            case 2:
                this.upMove = false;
                this.downMove = false;
                this.leftMove = true;
                this.rightMove = false;
                break;
            case 3:
                this.rightMove = true;
                this.upMove = false;
                this.downMove = false;
                this.leftMove = false;
                break;
        }
    }

    //检测与墙碰撞
    public boolean checkCollisionWall(List<BaseObstacle> walls) {
        for (BaseObstacle wall : walls) {
            if (wall.getRectangle().intersects(this.getRectangle())) {
                if (!wall.getClass().getName().equals("com.tankwars.model.obstacles.Woods")) {
                    if (type != 1) {//玩家坦克不触发随机方向
                        ranDirection();//调整方向
                    }
                    return true;
                }
            }
        }
        return false;
    }

    //检测坦克碰撞
    public boolean checkCollisionTank(List<Tank> tanks) {
        for (Tank tank : tanks) {
            if (this != tank) {
                if (tank.getNormalRectangle().intersects(this.getRectangle())) {
                    if (type != 1) {//玩家坦克不触发随机方向
                        ranDirection();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void drawing(Graphics g) {
        g.setColor(Color.RED);
        if (this.y == 0) {
            g.fillRect(this.x, this.y + 30, width / bloodLimit * blood, 5);
        } else {
            g.fillRect(this.x, this.y - 10, width / bloodLimit * blood, 5);
        }

        g.drawImage(tankImg, this.x, this.y, this.width, this.height, null);
    }

    public Rectangle getRectangle() {
        if (upMove)
            return new Rectangle(this.x, this.y - this.speed, this.width, this.height);
        if (downMove)
            return new Rectangle(this.x, this.y + this.speed, this.width, this.height);
        if (leftMove)
            return new Rectangle(this.x - this.speed, this.y, this.width, this.height);
        if (rightMove)
            return new Rectangle(this.x + this.speed, this.y, this.width, this.height);
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    public Rectangle getNormalRectangle() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

}

