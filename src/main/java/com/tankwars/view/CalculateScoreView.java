package com.tankwars.view;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.CalculateScoreWindowListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 18:04
 * @PackageName:com.tankwars.view
 * @ClassName: CalculateScoreView
 * @Description: TODO
 * @Version 1.0
 */
public class CalculateScoreView extends JFrame {
    public CalculateScoreViewPanel calculateScoreViewPanel;
    public CalculateScoreView(Controller controller){
        calculateScoreViewPanel=new CalculateScoreViewPanel();
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(430,430);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        calculateScoreViewPanel=new CalculateScoreViewPanel();

        addWindowListener(new CalculateScoreWindowListener(controller));
        add(calculateScoreViewPanel);
        setVisible(false);
    }
}
