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
    List<Tank> enemyTank;

    Controller controller;


    public RefreshPanelTimer(Controller controller, List<Tank> enemyTank) {
        this.controller = controller;
        this.enemyTank=enemyTank;
        timer = new Timer(30, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(controller.runTime);

            if (controller.runTime!=0){
                controller.runTime=controller.runTime-50;
            }else {
                for (Tank tank1:enemyTank) {
                    tank1.ranDirection();
                }
                controller.runTime=3000;
            }
            for (Tank tank1:enemyTank) {
                if (!tank1.checkCollision(controller.maps.walls)){
                    tank1.move();
                }
            }

            UI.mainGameView.mainGameViewPanel.repaint();
        }
    };
}
