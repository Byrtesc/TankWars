package com.tankwars.view;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.TankControlKeyListener;
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
        this.addKeyListener(new TankControlKeyListener(controller.tank));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        controller.tank.drawing(g);
        for (Tank tank1:controller.enemyTank) {
            tank1.drawing(g);
        }

        controller.maps.drawMap(g);
    }

}
