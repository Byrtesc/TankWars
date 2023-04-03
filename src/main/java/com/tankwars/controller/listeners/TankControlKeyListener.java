package com.tankwars.controller.listeners;

import com.tankwars.model.Tank;

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
    Tank playerTank1;
    Tank playerTank2;

    public TankControlKeyListener(List<Tank> tanks) {
        this.tanks = tanks;
        playerTank1 = tanks.get(0);
        playerTank2 = tanks.get(1);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        //玩家一
        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerTank1.upDateDirectionState();
            playerTank1.upMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerTank1.upDateDirectionState();
            playerTank1.downMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            playerTank1.upDateDirectionState();
            playerTank1.leftMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            playerTank1.upDateDirectionState();
            playerTank1.rightMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            playerTank1.attack();
        }

        //玩家而
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            playerTank2.upDateDirectionState();
            playerTank2.upMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            playerTank2.upDateDirectionState();
            playerTank2.downMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            playerTank2.upDateDirectionState();
            playerTank2.leftMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            playerTank2.upDateDirectionState();
            playerTank2.rightMove = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            playerTank2.attack();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);

        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerTank1.upMove = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerTank1.downMove = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            playerTank1.leftMove = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            playerTank1.rightMove = false;
        }


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
