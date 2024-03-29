package com.tankwars.controller.listeners;

import com.tankwars.ai.Node;
import com.tankwars.controller.Controller;
import com.tankwars.model.Tank;
import com.tankwars.view.UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 22:42
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: TankControlListener
 * @Description: TODO
 * @Version 1.0
 */
public class TankControlKeyListener extends KeyAdapter {
    List<Tank> tanks;
    Controller controller;
    Tank playerTank1;
    Tank playerTank2;

    public TankControlKeyListener(List<Tank> tanks, Controller controller) {
        this.controller = controller;
        this.tanks = tanks;
    }

    public void updatePlayerTankControl() {
        this.playerTank1 = controller.playerTank1;
        if (controller.playerNum == 2) {
            this.playerTank2 = controller.playerTank2;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        updatePlayerTankControl();

        if (controller.playerTanks.contains(controller.playerTank1)) {
            //玩家一
            if (e.getKeyCode() == KeyEvent.VK_W) {
                playerTank1.upDateDirectionState();
                playerTank1.upMove = true;
                playerTank1.downMove = false;
                playerTank1.leftMove = false;
                playerTank1.rightMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                playerTank1.upDateDirectionState();
                playerTank1.upMove = false;
                playerTank1.downMove = true;
                playerTank1.leftMove = false;
                playerTank1.rightMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                playerTank1.upDateDirectionState();
                playerTank1.upMove = false;
                playerTank1.downMove = false;
                playerTank1.leftMove = true;
                playerTank1.rightMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                playerTank1.upDateDirectionState();
                playerTank1.upMove = false;
                playerTank1.downMove = false;
                playerTank1.leftMove = false;
                playerTank1.rightMove = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                playerTank1.attack();
            }
        }

        if (controller.playerTanks.contains(controller.playerTank2)) {
            //玩家二
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerTank2.upDateDirectionState();
                playerTank2.upMove = true;
                playerTank2.downMove = false;
                playerTank2.leftMove = false;
                playerTank2.rightMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerTank2.upDateDirectionState();
                playerTank2.upMove = false;
                playerTank2.downMove = true;
                playerTank2.leftMove = false;
                playerTank2.rightMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                playerTank2.upDateDirectionState();
                playerTank2.upMove = false;
                playerTank2.downMove = false;
                playerTank2.leftMove = true;
                playerTank2.rightMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                playerTank2.upDateDirectionState();
                playerTank2.upMove = false;
                playerTank2.downMove = false;
                playerTank2.leftMove = false;
                playerTank2.rightMove = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                playerTank2.attack();
            }
        }
        //开始和暂停
        if (e.getKeyCode() == KeyEvent.VK_P) {
            controller.isStart = false;
            controller.refreshTimer.timer.stop();
            System.out.println("游戏暂停");
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {
            controller.isStart = true;
            controller.refreshTimer.timer.start();
            System.out.println("游戏继续");
        }

        if (controller.diyModel&&controller.diyGameIsStart==false) {//diy地图模式
            System.out.println(e.getKeyCode());
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    controller.diyBlock.move(8);
                    break;
                case KeyEvent.VK_DOWN:
                    controller.diyBlock.move(2);
                    break;
                case KeyEvent.VK_LEFT:
                    controller.diyBlock.move(4);
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.diyBlock.move(6);
                    break;
                case KeyEvent.VK_1:
                    controller.diyBlock.updateBlock(1);
                    break;
                case KeyEvent.VK_2:
                    controller.diyBlock.updateBlock(2);
                    break;
                case KeyEvent.VK_3:
                    controller.diyBlock.updateBlock(3);
                    break;
                case KeyEvent.VK_4:
                    controller.diyBlock.updateBlock(4);
                    break;
                case KeyEvent.VK_0:
                    controller.diyBlock.updateBlock(0);
                    break;
                case KeyEvent.VK_SPACE:
                    controller.diyBlock.putBlock();
                    break;
                case KeyEvent.VK_ENTER:
                    break;
            }
            UI.mainGameView.mainGameViewPanel.repaint();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        updatePlayerTankControl();
        if (controller.playerTanks.contains(controller.playerTank1)) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                if (controller.enemyAiTank!=null){
                    controller.enemyAiTank.moveToNodeList();
                }
                playerTank1.upMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                if (controller.enemyAiTank!=null){
                    controller.enemyAiTank.moveToNodeList();
                }
                playerTank1.downMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                if (controller.enemyAiTank!=null){
                    controller.enemyAiTank.moveToNodeList();
                }
                playerTank1.leftMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                if (controller.enemyAiTank!=null){
                    controller.enemyAiTank.moveToNodeList();
                }
                playerTank1.rightMove = false;
            }
        }
        if (controller.playerTanks.contains(controller.playerTank2)) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerTank2.upMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerTank2.downMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                playerTank2.leftMove = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                playerTank2.rightMove = false;
            }
        }


    }
}
