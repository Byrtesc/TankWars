package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

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
                controller.isStart=true;
                controller.updateGameNewData();
                controller.refreshTimer.timer.start();
                UI.mainGameView.menuItemRestartGame.setEnabled(true);
                break;
            case "stopGame":
                controller.isStart=false;
                controller.refreshTimer.timer.stop();
                break;
            case "restartGame":
                controller.refreshTimer.timer.stop();
                controller.playerHomeHp=1;
                controller.isStart=true;
                controller.updateGameNewData();
                controller.refreshTimer.timer.start();
                controller.allScore=controller.allScore-controller.nowScore;
                controller.allDesTankNum=controller.allDesTankNum-controller.nowDesTankNum;
                controller.nowDesTankNum=0;
                controller.nowScore=0;
                //重置数据
                break;
            case "custom":
                UI.customSettingView.setVisible(true);
                break;
            case "rankBoard":
                UI.rankBoardView.setVisible(true);
                break;
        }
    }
}
