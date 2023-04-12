package com.tankwars.controller.listeners;

import com.tankwars.controller.Controller;
import com.tankwars.model.obstacles.DiyBlock;
import com.tankwars.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author yangmingquan
 * @Date 2023/4/9 20:58
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: SelectModelListener
 * @Description: TODO
 * @Version 1.0
 */
public class SelectModelListener implements ActionListener {
    Controller controller;
    public SelectModelListener(Controller controller){
        this.controller=controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "onePlayer":
                controller.playerNum=1;
                UI.mainGameView.setVisible(true);
                UI.selectModelView.setVisible(false);
                break;
            case "twoPlayer":
                controller.playerNum=2;
                UI.mainGameView.setVisible(true);
                UI.selectModelView.setVisible(false);
                break;
            case "customModel":
                controller.diyModel=true;
                controller.diyBlock=new DiyBlock(0,0,controller);
                controller.diyMapObstacleList.addAll(controller.homeNormalWalls);
                UI.mainGameView.setVisible(true);
                UI.selectModelView.setVisible(false);
                break;
            case "aiMode":
                controller.aiMode=true;
                UI.mainGameView.setVisible(true);
                UI.selectModelView.setVisible(false);
                break;
        }
    }
}
