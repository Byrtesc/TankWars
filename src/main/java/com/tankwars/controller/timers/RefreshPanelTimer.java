package com.tankwars.controller.timers;

import com.tankwars.controller.Controller;
import com.tankwars.model.buildings.Building;
import com.tankwars.model.tanks.PlayerTank;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    PlayerTank playerTank;
    Controller controller;

    public RefreshPanelTimer(Controller controller, PlayerTank playerTank) {
        this.controller = controller;
        this.playerTank = playerTank;
        timer = new Timer(30, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (Building wall : controller.maps.walls) {
                if (wall.getRectangle().intersects(playerTank.getRectangle())){
                    if (!wall.getClass().getName().equals("com.tankwars.model.buildings.Woods")) {
                        System.out.println("发生碰撞");
                        playerTank.upDateDirectionState();
                        playerTank.moveStop();
                    }
                }
            }
            playerTank.move();
            UI.mainGameView.mainGameViewPanel.repaint();
        }
    };
}
