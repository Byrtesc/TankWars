package com.tankwars.view;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.TankControlKeyListener;
import com.tankwars.model.buildings.BirthPoint;
import com.tankwars.model.tanks.Tank;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/25 21:37
 * @PackageName:com.tankwars.view
 * @ClassName: MainViewGameViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class MainGameViewPanel extends JPanel {

    Controller controller;

    public MainGameViewPanel(Controller controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(555, 530));
        setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new TankControlKeyListener(controller.playerTanks));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Tank playerTank : controller.playerTanks) {
            playerTank.drawing(g);
        }

        for (Tank enemyTank : controller.enemyTanks) {
            enemyTank.drawing(g);
        }

        controller.maps.drawMap(g);
    }

}
