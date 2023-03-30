package com.tankwars.controller.timers;

import com.tankwars.controller.Controller;
import com.tankwars.model.buildings.BirthPoint;
import com.tankwars.model.buildings.Building;
import com.tankwars.model.tanks.Tank;
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
    Tank tank;
    List<Tank> enemyTanks;
    List<Tank> playerTanks;

    Controller controller;


    public RefreshPanelTimer(Controller controller, List<Tank> enemyTanks, List<Tank> playerTanks) {
        this.controller = controller;
        this.enemyTanks = enemyTanks;
        this.playerTanks = playerTanks;
        timer = new Timer(30, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (enemyTanks.size() < 10) {
                if (controller.generateTime!=0){
                    int i = new Random().nextInt(2);
                    if (controller.birthPoints.get(i).checkEmpty(enemyTanks)) {
                        System.out.println(controller.birthPoints.get(i).checkEmpty(enemyTanks));
                        enemyTanks.add(new Tank(controller.birthPoints.get(i).x, controller.birthPoints.get(i).y, 2, 1));
                    }
                    controller.generateTime=controller.generateTime-50;
                }else {
                    controller.generateTime=3000;
                }
            }



            for (Tank playerTank : playerTanks) {
                if (!playerTank.checkCollisionWall(controller.maps.walls) && !playerTank.checkCollisionTank(controller.enemyTanks) && !playerTank.checkCollisionTank(controller.playerTanks)) {
                    playerTank.move();
                    System.out.println("坐标"+playerTank.x+" "+playerTank.y);
                }

            }
            if (controller.runTime != 0) {
                controller.runTime = controller.runTime - 50;
            } else {
                for (Tank enemyTank : enemyTanks) {
                    enemyTank.ranDirection();
                }
                controller.runTime = 3000;
            }
            for (Tank enemyTank : enemyTanks) {
                if (!enemyTank.checkCollisionWall(controller.maps.walls) && !enemyTank.checkCollisionTank(controller.playerTanks) && !enemyTank.checkCollisionTank(controller.enemyTanks)) {
                    enemyTank.move();
                }
            }

            UI.mainGameView.mainGameViewPanel.repaint();
        }
    };
}
