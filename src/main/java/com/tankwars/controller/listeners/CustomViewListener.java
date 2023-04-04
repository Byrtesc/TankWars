package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;
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
                controller.selectedMap= (int) UI.customSettingView.customSettingViewPanel.stageNumCombox.getSelectedItem()-1;
                //System.out.println(UI.customSettingView.customSettingViewPanel.tankSpeedCombox.getSelectedItem());
                controller.updateGameNewData();
                break;
            case "cancel":
                break;
        }
    }
}
