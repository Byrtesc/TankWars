package com.tankwars.view.main;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.MenuBarListener;
import com.tankwars.controller.listeners.WindowsListener;
import com.tankwars.view.UI;

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

    public JMenuItem menuItemStartGame;
    public JMenuItem menuItemRestartGame;
    public JMenuItem menuItemRank;
    public JMenuItem menuItemCustom;
    public JMenuItem menuItemExit;
    public JMenuItem menuItemAbout;
    public JMenuItem menuItemDescription;
    public JMenuItem menuItemHistory;

    public MainGameView(Controller controller) {
        mainGameViewPanel = new MainGameViewPanel(controller);
        mainGameViewInfoPanel = new MainGameViewInfoPanel(controller);
        /*
         * 窗口要素
         */
        setTitle(UI.GAME_AUTHOR_NAME);
        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").equals("Windows 10")||System.getProperty("os.name").equals("Windows 11")){
            setSize(800, 570);
        }else {
            setSize(800, 590);
        }
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowsListener());
        setLayout(new BorderLayout());

        MenuBarListener menuBarListener = new MenuBarListener(controller);
        //添加菜单栏
        JMenuBar menuBar = new JMenuBar();
        //添加游戏菜单及子项
        JMenu menuGame = new JMenu("游戏");
        menuItemStartGame = new JMenuItem("开始游戏");
        menuItemStartGame.addActionListener(menuBarListener);
        menuItemStartGame.setActionCommand("startGame");

        menuItemRestartGame = new JMenuItem("重新开始");
        menuItemRestartGame.addActionListener(menuBarListener);
        menuItemRestartGame.setActionCommand("restartGame");
        menuItemRestartGame.setEnabled(false);

        menuItemRank = new JMenuItem("排行榜");
        menuItemRank.addActionListener(menuBarListener);
        menuItemRank.setActionCommand("rankBoard");

        menuItemHistory = new JMenuItem("历史游玩记录");
        menuItemHistory.addActionListener(menuBarListener);
        menuItemHistory.setActionCommand("history");

        menuItemCustom = new JMenuItem("自定义");
        menuItemCustom.addActionListener(menuBarListener);
        menuItemCustom.setActionCommand("custom");

        menuItemExit = new JMenuItem("退出");
        menuItemExit.addActionListener(menuBarListener);
        menuItemExit.setActionCommand("exit");


        menuGame.add(menuItemStartGame);
        menuGame.add(menuItemRestartGame);
        menuGame.add(menuItemRank);
        menuGame.add(menuItemHistory);
        menuGame.add(menuItemExit);
        menuGame.add(menuItemCustom);
        menuGame.add(menuItemExit);


        //添加帮助菜单及子项
        JMenu menuHelp = new JMenu("帮助");
        menuItemAbout = new JMenuItem("关于");
        menuItemAbout.addActionListener(menuBarListener);
        menuItemAbout.setActionCommand("about");
        menuItemDescription = new JMenuItem("游戏说明");
        menuItemDescription.addActionListener(menuBarListener);
        menuItemDescription.setActionCommand("description");

        menuHelp.add(menuItemDescription);
        menuHelp.add(menuItemAbout);



        //菜单栏添加菜单项
        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        //添加组件
        setJMenuBar(menuBar);
        //添加按键监听器开始或暂停
        add(mainGameViewPanel, BorderLayout.CENTER);
        add(mainGameViewInfoPanel, BorderLayout.EAST);
        setVisible(false);
    }
}
