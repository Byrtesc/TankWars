package com.tankwars.view;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/27 9:47
 * @PackageName:com.tankwars.view
 * @ClassName: CustomSettingViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class CustomSettingViewPanel extends JPanel {
    Controller controller;

    public CustomSettingViewPanel(Controller controller) {
        this.controller = controller;
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 0;
        gbc.weighty = 0;

        gbc.gridwidth = 1;
        JRadioButton onePlayerRadioButton = new JRadioButton("单人游戏");
        gridBagLayout.setConstraints(onePlayerRadioButton, gbc);

        gbc.gridwidth = 0;
        JRadioButton twoPlayerRadioButton = new JRadioButton("双人游戏");
        gridBagLayout.setConstraints(twoPlayerRadioButton, gbc);

        gbc.insets=new Insets(10,0,0,0);

        gbc.gridwidth = 1;
        JRadioButton normalGameRadioButton = new JRadioButton("正常游戏");
        gridBagLayout.setConstraints(normalGameRadioButton, gbc);

        gbc.gridwidth = 0;
        JRadioButton customGameRadioButton = new JRadioButton("自选游戏");
        gridBagLayout.setConstraints(customGameRadioButton, gbc);

        gbc.gridwidth = 1;
        JLabel selectStepLabel = new JLabel("请选择关卡数  ");
        gridBagLayout.setConstraints(selectStepLabel, gbc);

        gbc.gridwidth = 0;
        JComboBox<Integer> stepNumCombox = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8});
        gridBagLayout.setConstraints(stepNumCombox, gbc);

        gbc.insets=new Insets(10,0,0,0);

        gbc.gridwidth = 1;
        JLabel tankSpeedLabel = new JLabel("坦克速度");
        gridBagLayout.setConstraints(tankSpeedLabel, gbc);

        gbc.gridwidth = 0;
        JComboBox<Integer> tankSpeedCombox = new JComboBox<>(new Integer[]{0,1,2,3,4,5,6,7,8});
        gridBagLayout.setConstraints(tankSpeedCombox, gbc);

        gbc.insets=new Insets(60,10,0,10);
        gbc.gridwidth = 1;
        JButton identifyButton = new JButton("确定");
        gridBagLayout.setConstraints(identifyButton, gbc);

        
        gbc.gridwidth = 0;
        JButton cancelButton = new JButton("取消");
        gridBagLayout.setConstraints(cancelButton, gbc);

        setLayout(gridBagLayout);
        add(onePlayerRadioButton);
        add(twoPlayerRadioButton);
        add(normalGameRadioButton);
        add(customGameRadioButton);
        add(selectStepLabel);
        add(stepNumCombox);
        add(tankSpeedLabel);
        add(tankSpeedCombox);
        add(identifyButton);
        add(cancelButton);
    }
}
