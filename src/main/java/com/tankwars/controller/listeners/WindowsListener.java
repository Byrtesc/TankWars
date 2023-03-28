package com.tankwars.controller.listeners;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 16:35
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: WindowsListener
 * @Description: TODO
 * @Version 1.0
 */
public class WindowsListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        int res = JOptionPane.showConfirmDialog(null, "是否退出游戏？", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            System.out.println("确认退出");
            System.exit(0);
        }
    }
}
