package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author yangmingquan
 * @Date 2023/4/5 3:32
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: CalculateScoreWindowListener
 * @Description: TODO
 * @Version 1.0
 */
public class CalculateScoreWindowListener extends WindowAdapter {
    Controller controller;
    public CalculateScoreWindowListener(Controller controller){
        this.controller=controller;
    }
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        if (controller.customModel==false){
            if (controller.selectedMap<7){
                controller.selectedMap++;
                UI.calculateScoreView.setVisible(false);
                controller.updateGameNewData();
                controller.whiteTankNum=0;
                controller.yellowTankNum=0;
                controller.greenTankNum=0;
                controller.blueTankNum=0;
                controller.redTankNum=0;
                controller.nowScore=0;
                controller.nowDesTankNum=0;
            } else {
                UI.calculateScoreView.setVisible(false);
                controller.refreshTimer.timer.stop();
                JOptionPane.showMessageDialog(null,"恭喜通关，您的最终得分是:"+controller.allScore,"恭喜通关",JOptionPane.INFORMATION_MESSAGE);
                System.out.println(controller.selectedMap);
                //存入积分
                int saveResult=controller.saveRankScore(UI.mainGameView.mainGameViewInfoPanel.labelPlayerNameValues.getText(), controller.allScore);
                if (saveResult>0){
                    JOptionPane.showMessageDialog(null,"您的积分保存成功","恭喜通关",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else {
            UI.calculateScoreView.setVisible(false);
            controller.refreshTimer.timer.stop();
        }

    }
}
