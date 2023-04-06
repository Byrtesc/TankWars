package com.tankwars.controller;

import com.tankwars.model.Bullet;
import com.tankwars.model.Items;
import com.tankwars.model.Tank;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * @Author yangmingquan
 * @Date 2023/3/28 9:43
 * @PackageName:com.tankwars.controller.timers
 * @ClassName: RefreshPanel
 * @Description: TODO
 * @Version 1.0
 */
public class RefreshTimer {
    public Timer timer;
    Controller controller;
    int boomFreshTime = 10;

    public RefreshTimer(Controller controller) {
        this.controller = controller;
        timer = new Timer(10, actionListener);
    }

    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            //检查出生点是否为空，出生坦克
            if (controller.enemyTanks.size() < 10 && controller.nowStageEnemyTankNum < controller.needEnemyTankNum) {
                if (controller.generateTime != 0) {
                    int i = new Random().nextInt(2);
                    if (controller.birthPoints.get(i).checkEmpty(controller.enemyTanks) && controller.birthPoints.get(i).checkEmpty(controller.playerTanks)) {
                        String color = "";
                        switch (controller.scence.tankTypeList.get(controller.selectedMap).get(controller.nowStageEnemyTankNum)) {
                            case 1:
                                color = "white";
                                break;
                            case 2:
                                color = "yellow";
                                break;
                            case 3:
                                color = "green";
                                break;
                            case 4:
                                color = "blue";
                                break;
                            case 5:
                                color = "red";
                                break;
                        }
                        controller.enemyTanks.add(new Tank(controller.birthPoints.get(i).x, controller.birthPoints.get(i).y, 2, 1, 1, color, controller));
                        controller.nowStageEnemyTankNum++;
                    }
                    controller.generateTime = controller.generateTime - 1;
                } else {
                    controller.generateTime = 180;
                }
            }
            //如果坦克都为空那就下一关
            if (controller.nowBlueTankNum==0&&controller.nowYellowTankNum==0&&controller.nowGreenTankNum==0&&controller.nowWhiteTankNum==0&&controller.nowRedTankNum==0){
                UI.calculateScoreView.setVisible(true);
            }

            //检测玩家碰撞，无碰撞就移动
            for (Tank playerTank : controller.playerTanks) {
                if (!playerTank.checkCollisionWall(controller.walls) && !playerTank.checkCollisionTank(controller.enemyTanks) && !playerTank.checkCollisionTank(controller.playerTanks)) {
                    playerTank.move();
                }
            }

            //倒计时随机方向
            if (controller.runTime != 0) {
                controller.runTime = controller.runTime - 50;
            } else {
                for (Tank enemyTank : controller.enemyTanks) {
                    enemyTank.ranDirection();
                }
                controller.runTime = 3000;
            }

            //检测敌方坦克碰撞，无碰撞就移动
            for (
                    Tank enemyTank : controller.enemyTanks) {
                if (!enemyTank.checkCollisionWall(controller.walls) && !enemyTank.checkCollisionTank(controller.playerTanks) && !enemyTank.checkCollisionTank(controller.enemyTanks)) {
                    enemyTank.move();
                }
            }

            //清空打出了的、有了结果的子弹，也就是清空子弹壳
            controller.bullets.removeAll(controller.removeBullets);
            //清空子弹壳
            controller.removeBullets.clear();


            if (boomFreshTime == 0) {
                //清空爆炸效果
                controller.boomList.clear();
                boomFreshTime = 20;
            } else {
                boomFreshTime--;
            }

            //随机时间攻击
            if (controller.attackTime != 0) {
                controller.attackTime--;
            } else {
                for (Tank enemyTank : controller.enemyTanks) {
                    enemyTank.ranAttack();
                }
                controller.attackTime = 100;
            }

            //刷新页面子弹数量
            for (Bullet bullet : controller.bullets) {
                bullet.hitTank(controller.enemyTanks);
                bullet.hitTank(controller.playerTanks);
                bullet.hitBuilding(controller.walls);
            }
            //子弹移动
            for (Bullet bullet : controller.bullets) {
                bullet.move();
            }

            //倒计时消除buff
            //穿甲弹
            if (controller.playerTankPowerBuff){
                if (controller.resetTankPowerBuffTime==0){
                    for (Tank tank:controller.playerTanks) {
                        tank.power=0;
                    }
                    controller.resetTankPowerBuffTime=3000;
                    controller.playerTankPowerBuff=false;
                }else {
                    controller.resetTankPowerBuffTime--;
                }
            }
            //铁堡垒
            if (controller.ironHomeWallBuff){
                if (controller.resetironHomeWallTime==0){
                    controller.walls.removeAll(controller.homeIronWalls);
                    controller.walls.addAll(controller.homeNormalWalls);
                    controller.resetironHomeWallTime=3000;
                    controller.ironHomeWallBuff=false;
                }else {
                    controller.resetironHomeWallTime--;
                    System.out.println(controller.resetironHomeWallTime);
                }
            }

            //随机生成道具

            if (controller.ranItemsTime==0){
                int ranRoad=new Random().nextInt(controller.roads.size());
                int ranItem=new Random().nextInt(3);
                controller.items.add(new Items(controller.roads.get(ranRoad).x,controller.roads.get(ranRoad).y,ranItem,controller));
                controller.ranItemsTime=1000;
            }else{
                controller.ranItemsTime--;
            }

            if (controller.items.size()>0){
                if (controller.itemDisappearTime==0){
                    controller.removeItems.add(controller.items.get(0));
                    controller.itemDisappearTime=500;
                }else{
                    controller.itemDisappearTime--;
                }
            }

            controller.items.removeAll(controller.removeItems);

            for (Items item: controller.items){
                item.getBuff(controller.playerTanks);
            }

            //更新页面数据信息

            UI.mainGameView.mainGameViewInfoPanel.labelWhiteTank.setText("x " + controller.nowWhiteTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelYellowTank.setText("x " + controller.nowYellowTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelGreenTank.setText("x " + controller.nowGreenTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelBlueTank.setText("x " + controller.nowBlueTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelRedTank.setText("x " + controller.nowRedTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelThisLevelDestroyTankValues.setText("x " + controller.nowDesTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelThisLevelGetScoreValues.setText("x " + controller.nowScore);
            UI.mainGameView.mainGameViewInfoPanel.labelAllDestroyTankValues.setText("x " + controller.allDesTankNum);
            UI.mainGameView.mainGameViewInfoPanel.labelAllGetScoreValues.setText("x " + controller.allScore);


            UI.calculateScoreView.calculateScoreViewPanel.labelWhiteTank.setText(" " + controller.whiteTankNum+" ");
            UI.calculateScoreView.calculateScoreViewPanel.labelYellowTank.setText(" " + controller.yellowTankNum+" ");
            UI.calculateScoreView.calculateScoreViewPanel.labelGreenTank.setText(" " + controller.greenTankNum+" ");
            UI.calculateScoreView.calculateScoreViewPanel.labelBlueTank.setText(" " + controller.blueTankNum+" ");
            UI.calculateScoreView.calculateScoreViewPanel.labelRedTank.setText(" " + controller.redTankNum+" ");

            UI.calculateScoreView.calculateScoreViewPanel.labelStage.setText("关卡:" + (controller.selectedMap + 1));
            UI.calculateScoreView.calculateScoreViewPanel.labelWhiteTankTotalValues.setText("X  100  =  " + (controller.whiteTankNum * 100));
            UI.calculateScoreView.calculateScoreViewPanel.labelYellowTankTotalValues.setText("X  200  =  " + (controller.yellowTankNum * 200));
            UI.calculateScoreView.calculateScoreViewPanel.labelGreenTankTotalValues.setText("X  200  =  " + (controller.greenTankNum * 200));
            UI.calculateScoreView.calculateScoreViewPanel.labelBlueTankTotalValues.setText("X  300  =  " + (controller.blueTankNum * 300));
            UI.calculateScoreView.calculateScoreViewPanel.labelRedTankTotalValues.setText("X  500  =  " + (controller.redTankNum * 500));
            UI.calculateScoreView.calculateScoreViewPanel.labelTankTotalValues.setText("坦克总数:" + (controller.whiteTankNum + controller.yellowTankNum + controller.greenTankNum + controller.blueTankNum + controller.redTankNum));
            UI.calculateScoreView.calculateScoreViewPanel.labelScoreTotalValues.setText("    总计积分:" + (controller.whiteTankNum * 100 + controller.yellowTankNum * 200 + controller.greenTankNum * 200 + controller.blueTankNum * 300 + controller.redTankNum * 500));

            //刷新界面
            UI.mainGameView.mainGameViewPanel.repaint();
            UI.mainGameView.mainGameViewInfoPanel.repaint();
            UI.calculateScoreView.calculateScoreViewPanel.repaint();
        }
    };
}
