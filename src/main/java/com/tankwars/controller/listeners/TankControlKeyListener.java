package com.tankwars.controller.listeners;

import com.tankwars.model.tanks.PlayerTank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 22:42
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: TankControlListener
 * @Description: TODO
 * @Version 1.0
 */
public class TankControlKeyListener extends KeyAdapter {
    PlayerTank playerTank;

    public TankControlKeyListener(PlayerTank playerTank) {
        this.playerTank = playerTank;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("上"+e.getKeyCode());
            playerTank.direction=8;
            playerTank.upDateDirectionState();
            playerTank.upMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("下"+e.getKeyCode());
            playerTank.direction=2;
            playerTank.upDateDirectionState();
            playerTank.downMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("左"+e.getKeyCode());
            playerTank.direction=4;
            playerTank.upDateDirectionState();
            playerTank.leftMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("右"+e.getKeyCode());
            playerTank.direction=6;
            playerTank.upDateDirectionState();
            playerTank.rightMove=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerTank.upMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerTank.downMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            playerTank.leftMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            playerTank.rightMove=false;
        }
    }
}
