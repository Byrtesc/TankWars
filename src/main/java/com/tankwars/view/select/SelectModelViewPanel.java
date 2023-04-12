package com.tankwars.view.select;

import com.tankwars.controller.Controller;
import com.tankwars.controller.listeners.SelectModelListener;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/4/9 20:11
 * @PackageName:com.tankwars.view
 * @ClassName: SelectModelView
 * @Description: TODO
 * @Version 1.0
 */
public class SelectModelViewPanel extends JPanel {
    public SelectModelViewPanel(Controller controller){
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        SelectModelListener selectModelListener = new SelectModelListener(controller);
        gbc.fill=GridBagConstraints.BOTH;

        gbc.weightx=0;
        gbc.weighty=0;
        gbc.insets=new Insets(30,20,30,20);
        JButton onePlayerButton=new JButton("单人模式");
        JButton twoPlayerButton=new JButton("双人模式");
        JButton aiModeButton=new JButton("Ai模式");
        JButton customButton=new JButton("自定义地图模式");

        onePlayerButton.setFont(new Font(Font.DIALOG,1,30));
        twoPlayerButton.setFont(new Font(Font.DIALOG,1,30));
        customButton.setFont(new Font(Font.DIALOG,1,30));
        aiModeButton.setFont(new Font(Font.DIALOG,1,30));

        onePlayerButton.addActionListener(selectModelListener);
        onePlayerButton.setActionCommand("onePlayer");
        twoPlayerButton.addActionListener(selectModelListener);
        twoPlayerButton.setActionCommand("twoPlayer");
        customButton.addActionListener(selectModelListener);
        customButton.setActionCommand("customModel");
        aiModeButton.addActionListener(selectModelListener);
        aiModeButton.setActionCommand("aiMode");
        gbc.gridwidth=1;
        gridBagLayout.setConstraints(onePlayerButton,gbc);
        gbc.gridwidth=0;
        gridBagLayout.setConstraints(twoPlayerButton,gbc);
        gridBagLayout.setConstraints(customButton,gbc);
        gridBagLayout.setConstraints(aiModeButton,gbc);
        setLayout(gridBagLayout);
        add(onePlayerButton);
        add(twoPlayerButton);
        add(customButton);
        add(aiModeButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("images/bg/bg3.png").getImage(),-10,-15,800,600,null);
    }
}
