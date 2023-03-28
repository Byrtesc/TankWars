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
        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerTank.direction = 8;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerTank.direction = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            playerTank.direction = 4;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            playerTank.direction = 6;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        playerTank.direction = 0;
    }
}
