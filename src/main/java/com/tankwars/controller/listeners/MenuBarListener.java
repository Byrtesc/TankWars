package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author yangmingquan
 * @Date 2023/4/3 10:09
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: MenuBarListener
 * @Description: TODO
 * @Version 1.0
 */
public class MenuBarListener implements ActionListener {
    Controller controller;

    public MenuBarListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "startGame":
                controller.refreshPanelTimer.timer.start();
                break;
            case "stopGame":
                controller.refreshPanelTimer.timer.stop();
                break;
        }
    }
}
