package com.tankwars.view;

import com.tankwars.controller.Controller;

import javax.swing.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 9:46
 * @PackageName:com.tankwars.view
 * @ClassName: CustomSettingView
 * @Description: TODO
 * @Version 1.0
 */
public class CustomSettingView extends JFrame {
    public CustomSettingViewPanel customSettingViewPanel;
    public CustomSettingView(Controller controller){
        customSettingViewPanel=new CustomSettingViewPanel(controller);
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        add(customSettingViewPanel);
        setVisible(true);
    }
}
