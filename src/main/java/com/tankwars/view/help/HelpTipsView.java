package com.tankwars.view.help;

import javax.swing.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 22:12
 * @PackageName:com.tankwars.view
 * @ClassName: HelpTipsView
 * @Description: TODO
 * @Version 1.0
 */
public class HelpTipsView extends JFrame {
    public HelpTipsViewPanel helpTipsViewPanel;

    public HelpTipsView() {
        /*
         * 窗口要素
         */
        setTitle("游戏帮助");
        setSize(350, 336);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        helpTipsViewPanel = new HelpTipsViewPanel();
        add(helpTipsViewPanel);
        setVisible(false);
    }
}
