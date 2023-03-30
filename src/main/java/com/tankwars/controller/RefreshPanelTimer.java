package com.tankwars.controller;

import com.tankwars.controller.Controller;
import com.tankwars.model.Bullet;
import com.tankwars.model.Tank;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;


/**
 * @Author yangmingquan
 * @Date 2023/3/28 9:43
 * @PackageName:com.tankwars.controller.timers
 * @ClassName: RefreshPanel
 * @Description: TODO
 * @Version 1.0
 */
public class RefreshPanelTimer {
    public Timer timer;
    Controller controller;


    public RefreshPanelTimer(Controller controller) {
        this.controller = controller;
        timer = new Timer(30, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (controller.enemyTanks.size() < 10) {
                if (controller.generateTime != 0) {
                    int i = new Random().nextInt(2);
                    if (controller.birthPoints.get(i).checkEmpty(controller.enemyTanks)) {
                        System.out.println();
                        System.out.println(controller.birthPoints.get(i).checkEmpty(controller.enemyTanks));
                        controller.enemyTanks.add(new Tank(controller.birthPoints.get(i).x, controller.birthPoints.get(i).y, 2, 1,controller));
                    }
                    controller.generateTime = controller.generateTime - 50;
                } else {
                    controller.generateTime = 3000;
                }
            }


            for (Tank playerTank : controller.playerTanks) {
                if (!playerTank.checkCollisionWall(controller.walls) && !playerTank.checkCollisionTank(controller.enemyTanks) && !playerTank.checkCollisionTank(controller.playerTanks)) {
                    playerTank.move();
                }

            }
            if (controller.runTime != 0) {
                controller.runTime = controller.runTime - 50;
            } else {
                for (Tank enemyTank : controller.enemyTanks) {
                    enemyTank.ranDirection();
                }
                controller.runTime = 3000;
            }
            for (Tank enemyTank : controller.enemyTanks) {
                if (!enemyTank.checkCollisionWall(controller.walls) && !enemyTank.checkCollisionTank(controller.playerTanks) && !enemyTank.checkCollisionTank(controller.enemyTanks)) {
                    enemyTank.move();
                }
            }

            controller.bullets.removeAll(controller.removeBullets);
            controller.removeBullets.clear();

            for (Bullet bullet : controller.bullets) {
                bullet.hitTank(controller.enemyTanks);
                bullet.hitBuilding(controller.walls);
            }
            for (Bullet bullet : controller.bullets) {
                bullet.move();
            }

            UI.mainGameView.mainGameViewPanel.repaint();
        }
    };
}
