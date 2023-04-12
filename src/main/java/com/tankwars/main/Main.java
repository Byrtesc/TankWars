package com.tankwars.main;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.tankwars.controller.Controller;
import com.tankwars.view.UI;


import javax.swing.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/24 16:53
 * @PackageName:com.tankwars.main
 * @ClassName: Main
 * @Description: 程序入口
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("这是入口函数");
        //美化包
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        Controller controller = new Controller();
        UI ui = new UI(controller);
//        new RefreshPanelTimer().timer.start();
    }
}
