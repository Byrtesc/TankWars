package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 * @Author yangmingquan
 * @Date 2023/3/26 2:22
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: WelcomeViewListener
 * @Description: TODO
 * @Version 1.0
 */
public class WelcomeViewListener implements ActionListener {
    Controller controller;
    String userName = null;

    public WelcomeViewListener(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "enterGame":
                userName = JOptionPane.showInputDialog(null, "请输入玩家名:", "坦克大战欢迎您，祝您游戏愉快！", JOptionPane.INFORMATION_MESSAGE);
                if (userName==null) {
                    break;
                }
                if (userName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "玩家名不能为空！", "请输入玩家名！", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                List list = controller.login(userName);
                if (list != null) {
                    UI.historyScoreView.scoreList = list;
                    UI.historyScoreView.historyScoreViewPanel.setScoreList(list);
                }
                UI.mainGameView.mainGameViewInfoPanel.labelPlayerNameValues.setText(userName);
                UI.welcomeView.setVisible(false);
                UI.selectModelView.setVisible(true);
//                UI.mainGameView.setVisible(true);
//                UI.historyScoreView.setVisible(true);
                break;
            case "exit":
                int result = JOptionPane.showConfirmDialog(null, "请问是否要退出游戏", null, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
        }
    }
}
