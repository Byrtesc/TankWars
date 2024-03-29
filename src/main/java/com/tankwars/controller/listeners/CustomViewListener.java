package com.tankwars.controller.listeners;

import com.tankwars.ai.Node;
import com.tankwars.controller.Controller;
import com.tankwars.model.Tank;
import com.tankwars.model.obstacles.BaseObstacle;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author yangmingquan
 * @Date 2023/4/3 20:59
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: CustomViewListener
 * @Description: TODO
 * @Version 1.0
 */
public class CustomViewListener implements ActionListener {
    Controller controller;
    public CustomViewListener(Controller controller) {
        this.controller=controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "identify":
                int res = JOptionPane.showConfirmDialog(null, "是否确认设置？", null, JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    System.out.println("确认设置");
                    controller.playerNum=UI.customSettingView.customSettingViewPanel.onePlayerRadioButton.isSelected()?1:UI.customSettingView.customSettingViewPanel.twoPlayerRadioButton.isSelected()?2:0;
                    System.out.println(controller.playerNum);
                    if (UI.customSettingView.customSettingViewPanel.customGameRadioButton.isSelected()){
                        controller.selectedMap= (int) UI.customSettingView.customSettingViewPanel.stageNumCombox.getSelectedItem()-1;
                        controller.nowEnemyspeed= (int) UI.customSettingView.customSettingViewPanel.tankSpeedCombox.getSelectedItem()-1;
                    }
                    //System.out.println(UI.customSettingView.customSettingViewPanel.tankSpeedCombox.getSelectedItem());
                    if (controller.selectedMap!=9){
                        controller.updateGameNewData();
                    }else {
                        //更新地图数据
                        controller.scence.updateMapData();
                        //获取地图障碍物
                        controller.walls=controller.scence.obstacleList.get(controller.selectedMap);
                        //把家放进去
                        controller.walls.addAll(controller.homeNormalWalls);
                    }
                    UI.customSettingView.setVisible(false);

                    if (!controller.diyModel){
                        controller.isStart=true;
                        controller.updateGameNewData();
                    }else {
                        controller.diyGameIsStart=true;
                        controller.playerHomeHp=1;
                        controller.walls.addAll(controller.diyMapObstacleList);
                        controller.playerTank1 = new Tank(90, 475, 1, 3, 3, "", controller);
                        controller.playerTanks.add(controller.playerTank1);
                    }
                    UI.mainGameView.menuItemStartGame.setEnabled(false);
                    UI.mainGameView.menuItemRestartGame.setEnabled(true);
                    controller.refreshTimer.timer.start();

                    controller.aiTimer.timer.start();
                    UI.mainGameView.menuItemRestartGame.setEnabled(true);
                }
                break;
            case "cancel":
                UI.customSettingView.setVisible(false);
                break;
            case "normalGame":
                UI.customSettingView.customSettingViewPanel.stageNumCombox.setEnabled(false);
                UI.customSettingView.customSettingViewPanel.tankSpeedCombox.setEnabled(false);
                controller.customModel=false;
                break;
            case "customGame":
                UI.customSettingView.customSettingViewPanel.stageNumCombox.setEnabled(true);
                UI.customSettingView.customSettingViewPanel.tankSpeedCombox.setEnabled(true);
                controller.customModel=true;
                break;
        }
    }
}
