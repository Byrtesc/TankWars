package com.tankwars.controller.timers;

import com.tankwars.controller.Controller;
import com.tankwars.model.buildings.Building;
import com.tankwars.model.tanks.Tank;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


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


    public RefreshPanelTimer(Controller controller, List<Tank> enemyTanks,List<Tank> playerTanks) {
        this.controller = controller;
        this.enemyTanks=enemyTanks;
        this.playerTanks=playerTanks;
        timer = new Timer(30, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Tank playerTank:playerTanks) {
                if (!playerTank.checkCollision(controller.maps.walls)){
                    playerTank.move();
                }
            }

            if (controller.runTime!=0){
                controller.runTime=controller.runTime-50;
            }else {
                for (Tank enemyTank:enemyTanks) {
                    enemyTank.ranDirection();
                }
                controller.runTime=3000;
            }
            for (Tank enemyTank:enemyTanks) {
                if (!enemyTank.checkCollision(controller.maps.walls)){
                    enemyTank.move();
                }
            }

            UI.mainGameView.mainGameViewPanel.repaint();
        }
    };
}
