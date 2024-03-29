package com.tankwars.view.history;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

import javax.swing.*;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 16:31
 * @PackageName:com.tankwars.view
 * @ClassName: HistoryScoreView
 * @Description: TODO
 * @Version 1.0
 */
public class HistoryScoreView extends JFrame {
    public HistoryScoreViewPanel historyScoreViewPanel;
    public List scoreList=null;
    public HistoryScoreView(Controller controller){
        /*
         * 窗口要素
         */
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(366, 660);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        historyScoreViewPanel = new HistoryScoreViewPanel(scoreList,controller);


        add(historyScoreViewPanel);
        setVisible(false);
    }
}
