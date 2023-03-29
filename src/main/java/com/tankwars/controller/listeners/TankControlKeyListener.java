package com.tankwars.controller.listeners;

import com.tankwars.model.tanks.Tank;

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
    Tank tank;

    public TankControlKeyListener(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("上"+e.getKeyCode());
            tank.direction=8;
            tank.upDateDirectionState();
            tank.upMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("下"+e.getKeyCode());
            tank.direction=2;
            tank.upDateDirectionState();
            tank.downMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("左"+e.getKeyCode());
            tank.direction=4;
            tank.upDateDirectionState();
            tank.leftMove=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("右"+e.getKeyCode());
            tank.direction=6;
            tank.upDateDirectionState();
            tank.rightMove=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            tank.upMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            tank.downMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            tank.leftMove=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            tank.rightMove=false;
        }
    }
}
