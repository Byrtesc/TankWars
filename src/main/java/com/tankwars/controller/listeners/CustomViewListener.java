package com.tankwars.controller.listeners;

import com.tankwars.ai.Node;
import com.tankwars.controller.Controller;
import com.tankwars.model.obstacles.BaseObstacle;
import com.tankwars.view.UI;

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
                controller.playerNum=UI.customSettingView.customSettingViewPanel.onePlayerRadioButton.isSelected()?1:UI.customSettingView.customSettingViewPanel.twoPlayerRadioButton.isSelected()?2:0;
                System.out.println(controller.playerNum);
                if (UI.customSettingView.customSettingViewPanel.customGameRadioButton.isSelected()){
                    controller.selectedMap= (int) UI.customSettingView.customSettingViewPanel.stageNumCombox.getSelectedItem()-1;
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
