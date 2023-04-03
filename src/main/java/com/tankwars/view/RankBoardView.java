package com.tankwars.view;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.util.List;

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
        setSize(560, 560);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        rankBoardViewPanel = new RankBoardViewPanel(controller);

        add(rankBoardViewPanel);

        setVisible(false);
    }
}
