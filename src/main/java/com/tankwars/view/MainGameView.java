package com.tankwars.view;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.MenuBarListener;
import com.tankwars.controller.listeners.WindowsListener;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/25 21:33
 * @PackageName:com.tankwars.view
 * @ClassName: GameMainView
 * @Description: TODO
 * @Version 1.0
 */
public class MainGameView extends JFrame {
    public MainGameViewPanel mainGameViewPanel;
    public MainGameViewInfoPanel mainGameViewInfoPanel;
    public Controller controller;

    public MainGameView(Controller controller) {
        mainGameViewPanel = new MainGameViewPanel(controller);
        mainGameViewInfoPanel = new MainGameViewInfoPanel();
        /*
         * 窗口要素
         */
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowsListener());
        setLayout(new BorderLayout());

        //添加菜单栏
        JMenuBar menuBar = new JMenuBar();
        //添加游戏菜单及子项
        JMenu menuGame = new JMenu("游戏");
        JMenuItem menuItemStartGame = new JMenuItem("开始游戏");
        menuItemStartGame.addActionListener(new MenuBarListener(controller));
        menuItemStartGame.setActionCommand("startGame");

        JMenuItem menuItemRestartGame = new JMenuItem("重新开始");
        JMenuItem menuItemRank = new JMenuItem("排行榜");
        JMenuItem menuItemCustom = new JMenuItem("自定义");
        JMenuItem menuItemExit = new JMenuItem("退出");
        menuItemRestartGame.setEnabled(false);

        menuGame.add(menuItemStartGame);
        menuGame.add(menuItemRestartGame);
        menuGame.add(menuItemRank);
        menuGame.add(menuItemCustom);
        menuGame.add(menuItemExit);

        //添加帮助菜单及子项
        JMenu menuHelp = new JMenu("帮助");
        JMenuItem menuItemAbout = new JMenuItem("关于");
        JMenuItem menuItemDescription = new JMenuItem("游戏说明");
        menuHelp.add(menuItemAbout);
        menuHelp.add(menuItemDescription);

        //菜单栏添加菜单项
        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        //添加组件
        setJMenuBar(menuBar);
        add(mainGameViewPanel, BorderLayout.CENTER);
        add(mainGameViewInfoPanel, BorderLayout.EAST);
        setVisible(false);
    }
}
