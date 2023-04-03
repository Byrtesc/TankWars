package com.tankwars.controller.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Author yangmingquan
 * @Date 2023/4/3 20:59
 * @PackageName:com.tankwars.controller.listeners
 * @ClassName: CustomViewListener
 * @Description: TODO
 * @Version 1.0
 */
public class CustomViewListener extends MouseAdapter {
    public CustomViewListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        System.out.println(e);
    }
}
