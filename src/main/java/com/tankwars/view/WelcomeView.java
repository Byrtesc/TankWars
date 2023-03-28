package com.tankwars.view;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.WelcomeViewListener;
import com.tankwars.controller.listeners.WindowsListener;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/25 21:05
 * @PackageName:com.tankwars.view
 * @ClassName: WelcomeView
 * @Description: 游戏欢迎界面
 * @Version 1.0
 */
public class WelcomeView extends JFrame {
    public WelcomeViewPanel welcomeViewPanel;

    public WelcomeView(Controller controller) {
        /*
         * 窗口要素
         */
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowsListener());
        //欢迎界面
        welcomeViewPanel = new WelcomeViewPanel(controller);

        //JFrame添加组件
        add(welcomeViewPanel);
        setVisible(true);
    }

}
