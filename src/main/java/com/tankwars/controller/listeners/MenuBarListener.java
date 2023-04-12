package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;
import com.tankwars.model.Tank;
import com.tankwars.view.UI;

import javax.swing.*;
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
                if (!controller.diyModel) {
                    controller.isStart = true;
                    controller.selectedMap=0;
                    controller.updateGameNewData();
                } else {
                    controller.diyGameIsStart = true;
                    controller.playerHomeHp = 1;
                    controller.walls.addAll(controller.diyMapObstacleList);
                    controller.playerTank1 = new Tank(90, 475, 1, 3, 3, "", controller);
                    controller.playerTanks.add(controller.playerTank1);
                }
                UI.mainGameView.menuItemStartGame.setEnabled(false);
                UI.mainGameView.menuItemRestartGame.setEnabled(true);
                controller.refreshTimer.timer.start();

                controller.aiTimer.timer.start();
                UI.mainGameView.menuItemRestartGame.setEnabled(true);
                break;
            case "stopGame":
                controller.isStart = false;
                controller.refreshTimer.timer.stop();
                controller.aiTimer.timer.stop();
                break;
            case "restartGame":
                controller.refreshTimer.timer.stop();
                UI.mainGameView.menuItemStartGame.setEnabled(false);
                UI.mainGameView.menuItemRestartGame.setEnabled(true);
                controller.playerHomeHp = 1;
                controller.isStart = true;
                controller.updateGameNewData();
                controller.refreshTimer.timer.start();
                controller.allScore = controller.allScore - controller.nowScore;
                controller.allDesTankNum = controller.allDesTankNum - controller.nowDesTankNum;
                controller.nowDesTankNum = 0;
                controller.nowScore = 0;
                //重置数据
                break;
            case "custom":
                UI.customSettingView.setVisible(true);
                break;
            case "rankBoard":
                UI.rankBoardView.setVisible(true);
                break;
            case "history":
                UI.historyScoreView.setVisible(true);
                break;
            case "about":
                JOptionPane.showMessageDialog(null, "游戏名: 坦克大战\n" + "版本号: 1.0\n" + "作者: 杨铭泉", "关于本游戏", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "description":
                break;
        }
    }
}
