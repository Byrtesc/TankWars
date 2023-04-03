package com.tankwars.controller.listeners;

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
    public CustomViewListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "identify":
                int playerNum=UI.customSettingView.customSettingViewPanel.onePlayerRadioButton.isSelected()?1:UI.customSettingView.customSettingViewPanel.twoPlayerRadioButton.isSelected()?2:0;
                System.out.println(playerNum);
//                System.out.println(UI.customSettingView.customSettingViewPanel.stepNumCombox.getSelectedItem());
//                System.out.println(UI.customSettingView.customSettingViewPanel.tankSpeedCombox.getSelectedItem());
                break;
            case "cancel":

                break;
        }
    }
}
