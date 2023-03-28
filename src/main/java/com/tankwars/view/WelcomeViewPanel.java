package com.tankwars.view;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.WelcomeViewListener;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 16:21
 * @PackageName:com.tankwars.view
 * @ClassName: WelcomeViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class WelcomeViewPanel extends JPanel {
    public WelcomeViewPanel(Controller controller) {
        setLayout(null);
        setSize(800, 600);
        //新建监听
        WelcomeViewListener welcomeViewListener = new WelcomeViewListener(controller);

        //进入游戏按钮
        JButton buttonEnterGame = new JButton("进入游戏");
        buttonEnterGame.setSize(200, 30);
        buttonEnterGame.setFont(new Font(Font.DIALOG, 1, 20));
        buttonEnterGame.setLocation(this.getWidth() / 2 - buttonEnterGame.getWidth() / 2, this.getHeight() - 200);
        buttonEnterGame.setActionCommand("enterGame");
        buttonEnterGame.addActionListener(welcomeViewListener);

        //退出游戏按钮
        JButton buttonExitGame = new JButton("退出游戏");
        buttonExitGame.setSize(200, 30);
        buttonExitGame.setFont(new Font(Font.DIALOG, 1, 20));
        buttonExitGame.setLocation(this.getWidth() / 2 - buttonEnterGame.getWidth() / 2, this.getHeight() - 150);
        buttonExitGame.setActionCommand("exit");
        buttonExitGame.addActionListener(welcomeViewListener);

        //Jpanel添加组件
        add(buttonEnterGame);
        add(buttonExitGame);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bgimg = new ImageIcon("images/background.png").getImage();
        g.drawImage(bgimg, 0, 0, 800, 600, null);
    }
}
