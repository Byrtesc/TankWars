package com.tankwars.view.help;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 22:13
 * @PackageName:com.tankwars.view
 * @ClassName: HelpTipsViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class HelpTipsViewPanel extends JPanel {
    public HelpTipsViewPanel() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("images/intro.png").getImage(),0,0,350,336,null);
    }
}
