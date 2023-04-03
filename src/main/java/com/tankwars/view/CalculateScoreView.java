package com.tankwars.view;

import javax.swing.*;

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
    public CalculateScoreView(){
        calculateScoreViewPanel=new CalculateScoreViewPanel();
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(430,430);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        calculateScoreViewPanel=new CalculateScoreViewPanel();

        add(calculateScoreViewPanel);
        setVisible(false);
    }
}
