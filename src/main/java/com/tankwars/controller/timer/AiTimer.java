package com.tankwars.controller.timer;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author yangmingquan
 * @Date 2023/4/12 0:11
 * @PackageName:com.tankwars.controller
 * @ClassName: AiTimer
 * @Description: TODO
 * @Version 1.0
 */
public class AiTimer {
    public Timer timer;
    Controller controller;

    public AiTimer(Controller controller) {
        this.controller = controller;
        timer = new Timer(10, actionListener);
    }

    public ActionListener actionListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (controller.movePath.size()>0){
                if (controller.enemyAiTank.y > controller.movePath.get(0).y) {
                    controller.enemyAiTank.upMove = true;
                    controller.enemyAiTank.downMove = false;
                    controller.enemyAiTank.leftMove = false;
                    controller.enemyAiTank.rightMove = false;
                } else if (controller.enemyAiTank.y < controller.movePath.get(0).y) {
                    controller.enemyAiTank.upMove = false;
                    controller.enemyAiTank.downMove = true;
                    controller.enemyAiTank.leftMove = false;
                    controller.enemyAiTank.rightMove = false;
                } else if (controller.enemyAiTank.x > controller.movePath.get(0).x) {
                    controller.enemyAiTank.upMove = false;
                    controller.enemyAiTank.downMove = false;
                    controller.enemyAiTank.leftMove = true;
                    controller.enemyAiTank.rightMove = false;
                } else if (controller.enemyAiTank.x < controller.movePath.get(0).x) {
                    controller.enemyAiTank.upMove = false;
                    controller.enemyAiTank.downMove = false;
                    controller.enemyAiTank.leftMove = false;
                    controller.enemyAiTank.rightMove = true;
                } else {
                    controller.enemyAiTank.upMove = false;
                    controller.enemyAiTank.downMove = false;
                    controller.enemyAiTank.leftMove = false;
                    controller.enemyAiTank.rightMove = false;
                    controller.movePath.remove(0);
                }
            }
//            controller.enemyAiTank.move();

        }
    };
}
