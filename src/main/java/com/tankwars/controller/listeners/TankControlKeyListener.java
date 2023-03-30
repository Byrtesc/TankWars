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
    List<Tank> tank;

    public TankControlKeyListener(List<Tank> tank) {
        this.tank = tank;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            tank.get(0).upDateDirectionState();
            tank.get(0).upMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            tank.get(0).upDateDirectionState();
            tank.get(0).downMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            tank.get(0).upDateDirectionState();
            tank.get(0).leftMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            tank.get(0).upDateDirectionState();
            tank.get(0).rightMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            tank.get(0).attack();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            tank.get(0).upMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            tank.get(0).downMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            tank.get(0).leftMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            tank.get(0).rightMove=false;
        }

    }
}
