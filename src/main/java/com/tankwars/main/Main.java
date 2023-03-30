package com.tankwars.main;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

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

        Controller controller = new Controller();
        UI ui = new UI(controller);
//        new RefreshPanelTimer().timer.start();
    }
}
