package com.tankwars.controller;

import com.tankwars.model.Bullet;
import com.tankwars.model.Tank;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * @Author yangmingquan
 * @Date 2023/3/28 9:43
 * @PackageName:com.tankwars.controller.timers
 * @ClassName: RefreshPanel
 * @Description: TODO
 * @Version 1.0
 */
public class RefreshTimer {
    public Timer timer;
    Controller controller;
    int boomFreshTime=30;

    public RefreshTimer(Controller controller) {
        this.controller = controller;
        timer = new Timer(10, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //检查出生点是否为空
            if (controller.enemyTanks.size() < 10) {
                if (controller.generateTime != 0) {
                    int i = new Random().nextInt(2);
                    if (controller.birthPoints.get(i).checkEmpty(controller.enemyTanks)&&controller.birthPoints.get(i).checkEmpty(controller.playerTanks)) {
                        controller.enemyTanks.add(new Tank(controller.birthPoints.get(i).x, controller.birthPoints.get(i).y, 2, 1,1,"yellow",controller));
                    }
                    controller.generateTime = controller.generateTime - 1;
                } else {
                    controller.generateTime = 180;
                }
            }

            //检测玩家碰撞，无碰撞就移动
            for (Tank playerTank : controller.playerTanks) {
                if (!playerTank.checkCollisionWall(controller.walls) && !playerTank.checkCollisionTank(controller.enemyTanks) && !playerTank.checkCollisionTank(controller.playerTanks)) {
                    playerTank.move();
                }
            }

            //倒计时随机方向
            if (controller.runTime != 0) {
                controller.runTime = controller.runTime - 50;
            } else {
                for (Tank enemyTank : controller.enemyTanks) {
                    enemyTank.ranDirection();
                }
                controller.runTime = 3000;
            }

            //检测敌方坦克碰撞，无碰撞就移动
            for (Tank enemyTank : controller.enemyTanks) {
                if (!enemyTank.checkCollisionWall(controller.walls) && !enemyTank.checkCollisionTank(controller.playerTanks) && !enemyTank.checkCollisionTank(controller.enemyTanks)) {
                    enemyTank.move();
                }
            }

            //清空打出了的、有了结果的子弹，也就是清空子弹壳
            controller.bullets.removeAll(controller.removeBullets);
            //清空子弹壳
            controller.removeBullets.clear();


            if (boomFreshTime==0){
                //清空爆炸效果
                controller.boomList.clear();
                boomFreshTime=20;
            }else {
                boomFreshTime--;
            }

            //随机时间攻击
            if (controller.attackTime!=0){
                controller.attackTime--;
            }else {
                for (Tank enemyTank : controller.enemyTanks) {
                    enemyTank.ranAttack();
                }
                controller.attackTime=100;
            }

            //刷新页面子弹数量
            for (Bullet bullet : controller.bullets) {
                bullet.hitTank(controller.enemyTanks);
                bullet.hitTank(controller.playerTanks);
                bullet.hitBuilding(controller.walls);
            }
            //子弹移动
            for (Bullet bullet : controller.bullets) {
                bullet.move();
            }

            //刷新界面
            UI.mainGameView.mainGameViewPanel.repaint();
        }
    };
}
