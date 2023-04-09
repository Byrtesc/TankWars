package com.tankwars.view.rank;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

import javax.swing.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 16:31
 * @PackageName:com.tankwars.view
 * @ClassName: RankBoardView
 * @Description: TODO
 * @Version 1.0
 */
public class RankBoardView extends JFrame {
    public RankBoardViewPanel rankBoardViewPanel;

    public RankBoardView(Controller controller) {
        /*
         * 窗口要素
         */
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(450, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        rankBoardViewPanel = new RankBoardViewPanel(controller);

        add(rankBoardViewPanel);

        setVisible(false);
    }
}
