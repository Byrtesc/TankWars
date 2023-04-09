package com.tankwars.view.select;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.WindowsListener;
import com.tankwars.view.UI;

import javax.swing.*;

/**
 * @Author yangmingquan
 * @Date 2023/4/9 20:11
 * @PackageName:com.tankwars.view
 * @ClassName: SelectModelView
 * @Description: TODO
 * @Version 1.0
 */
public class SelectModelView extends JFrame {
    public SelectModelViewPanel selectModelViewPanel;
    public SelectModelView(Controller controller){
        selectModelViewPanel=new SelectModelViewPanel(controller);
        setTitle(UI.GAME_AUTHOR_NAME);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowsListener());
        add(selectModelViewPanel);
        setVisible(false);
    }
}
