package com.tankwars.view.main;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/25 21:37
 * @PackageName:com.tankwars.view
 * @ClassName: MainViewGameViewInfoPanel
 * @Description: TODO
 * @Version 1.0
 */
public class MainGameViewInfoPanel extends JPanel {
    public JPanel topPanel;
    public JPanel middlePanel;
    public BottomPanel bottomPanel;

    public JLabel labelWhiteTank;
    public JLabel labelYellowTank;
    public JLabel labelGreenTank;
    public JLabel labelBlueTank;
    public JLabel labelRedTank;
    public JLabel labelPlayerNameValues;
    public JLabel labelThisLevelDestroyTankValues;
    public JLabel labelThisLevelGetScoreValues;
    public JLabel labelAllDestroyTankValues;
    public JLabel labelAllGetScoreValues;
    public JLabel LabelHpIcon;
    public JLabel LabelHptext;

    public MainGameViewInfoPanel(Controller controller) {

        setPreferredSize(new Dimension(230, 600));
        topPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new BottomPanel();
        setLayout(new GridLayout(3, 1));

        //上容器
        topPanel.setBackground(Color.black);
        topPanel.setSize(200, 200);
        topPanel.setLayout(null);
        //label设置文字

        JLabel labelTips = new JLabel("敌方坦克还有:");
        labelWhiteTank = new JLabel("x 0");
        labelYellowTank = new JLabel("x 0");
        labelGreenTank = new JLabel("x 0");
        labelBlueTank = new JLabel("x 0");
        labelRedTank = new JLabel("x 0");


        //label设置图片
        labelWhiteTank.setIcon(new ImageIcon("images/whiteTank.png"));
        labelYellowTank.setIcon(new ImageIcon("images/yellowTank.png"));
        labelGreenTank.setIcon(new ImageIcon("images/greenTank.png"));
        labelBlueTank.setIcon(new ImageIcon("images/blueTank.png"));
        labelRedTank.setIcon(new ImageIcon("images/redTank.png"));
        //label设置字体
        labelTips.setFont(new Font(Font.DIALOG, 1, 15));
        labelWhiteTank.setFont(new Font(Font.DIALOG, 1, 20));
        labelYellowTank.setFont(new Font(Font.DIALOG, 1, 20));
        labelGreenTank.setFont(new Font(Font.DIALOG, 1, 20));
        labelBlueTank.setFont(new Font(Font.DIALOG, 1, 20));
        labelRedTank.setFont(new Font(Font.DIALOG, 1, 20));

        labelTips.setForeground(Color.WHITE);
        labelWhiteTank.setForeground(Color.WHITE);
        labelYellowTank.setForeground(Color.WHITE);
        labelGreenTank.setForeground(Color.WHITE);
        labelBlueTank.setForeground(Color.WHITE);
        labelRedTank.setForeground(Color.WHITE);
        //label设置坐标
        labelTips.setBounds(10, 10, 100, 15);
        labelWhiteTank.setBounds(38, 38, 100, 35);
        labelYellowTank.setBounds(131, 38, 100, 35);
        labelGreenTank.setBounds(38, 80, 100, 35);
        labelBlueTank.setBounds(131, 80, 90, 35);
        labelRedTank.setBounds(90, 115, 100, 35);
        //上容器添加组件


        topPanel.add(labelTips);
        topPanel.add(labelWhiteTank);
        topPanel.add(labelYellowTank);
        topPanel.add(labelGreenTank);
        topPanel.add(labelBlueTank);
        topPanel.add(labelRedTank);


        //中容器
        middlePanel.setBackground(Color.black);
        middlePanel.setSize(200, 200);
        middlePanel.setLayout(null);
        JLabel labelOperationHelp = new JLabel("<html>" +
                "  &emsp&emsp;玩家一:&emsp&emsp&emsp;游戏操作<br>" +
                "  <div style=\"font-size:10px;\">" +
                "    &emsp&emsp向上：W&emsp;&emsp;向下：S<br>" +
                "    &emsp&emsp向左：A&emsp;&emsp;向右：D<br>" +
                "    &emsp&emsp射击：空格<br>\n" +
                "    &emsp&emsp暂停：P&emsp;&emsp;继续：C" +
                "  </div>" +
                "  &emsp&emsp;玩家二:<br>" +
                "  <div style=\"font-size:10px;\">" +
                "    &emsp&emsp向上：↑&emsp;&emsp;向下：↓<br>" +
                "    &emsp&emsp向左：←&emsp;&emsp;向右：→<br>" +
                "    &emsp&emsp射击：Enter<br>\n" +
                "  </div>" +
                "</html>");
        labelOperationHelp.setHorizontalTextPosition(JLabel.CENTER);
        labelOperationHelp.setVerticalAlignment(JLabel.TOP);
        labelOperationHelp.setBounds(0, 8, 200, 200);
        labelOperationHelp.setForeground(Color.WHITE);
        middlePanel.add(labelOperationHelp);

        //下容器
        bottomPanel.setBackground(Color.green);
        GridBagLayout gridBagLayout = new GridBagLayout();
        bottomPanel.setLayout(gridBagLayout);

        JLabel labelPlayerName = new JLabel("玩家: ");
        JLabel labelThisLevelDestroyTank = new JLabel("该关击毁坦克数量: ");
        JLabel labelThisLevelGetScore = new JLabel("该关得分: ");
        JLabel labelAllDestroyTank = new JLabel("总共击毁坦克数量: ");
        JLabel labelAllGetScore = new JLabel("总共得分: ");

        labelPlayerNameValues = new JLabel("null");
        labelThisLevelDestroyTankValues = new JLabel("0");
        labelThisLevelGetScoreValues = new JLabel("0");
        labelAllDestroyTankValues = new JLabel("0");
        labelAllGetScoreValues = new JLabel("0");

        labelPlayerName.setFont(new Font(Font.DIALOG, 1, 15));
        labelPlayerNameValues.setFont(new Font(Font.DIALOG, 1, 15));
        labelThisLevelDestroyTank.setFont(new Font(Font.DIALOG, 1, 15));
        labelThisLevelDestroyTankValues.setFont(new Font(Font.DIALOG, 1, 15));
        labelThisLevelGetScore.setFont(new Font(Font.DIALOG, 1, 15));
        labelThisLevelGetScoreValues.setFont(new Font(Font.DIALOG, 1, 15));
        labelAllDestroyTank.setFont(new Font(Font.DIALOG, 1, 15));
        labelAllDestroyTankValues.setFont(new Font(Font.DIALOG, 1, 15));
        labelAllGetScore.setFont(new Font(Font.DIALOG, 1, 15));
        labelAllGetScoreValues.setFont(new Font(Font.DIALOG, 1, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0;
        gbc.weighty = 0;

        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelPlayerName, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelPlayerNameValues, gbc);
        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelThisLevelDestroyTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelThisLevelDestroyTankValues, gbc);
        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelThisLevelGetScore, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelThisLevelGetScoreValues, gbc);
        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelAllDestroyTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelAllDestroyTankValues, gbc);
        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelAllGetScore, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelAllGetScoreValues, gbc);


        LabelHpIcon = new JLabel("坦克生命值 ");
        LabelHptext = new JLabel("0");
        LabelHpIcon.setFont(new Font(Font.DIALOG, 1, 15));
        LabelHptext.setFont(new Font(Font.DIALOG, 1, 15));
        LabelHpIcon.setIcon(new ImageIcon("images/hp.png"));
        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(LabelHpIcon, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(LabelHptext, gbc);


        bottomPanel.add(labelPlayerName);
        bottomPanel.add(labelPlayerNameValues);
        bottomPanel.add(labelThisLevelDestroyTank);
        bottomPanel.add(labelThisLevelDestroyTankValues);
        bottomPanel.add(labelThisLevelGetScore);
        bottomPanel.add(labelThisLevelGetScoreValues);
        bottomPanel.add(labelAllDestroyTank);
        bottomPanel.add(labelAllDestroyTankValues);
        bottomPanel.add(labelAllGetScore);
        bottomPanel.add(labelAllGetScoreValues);
        bottomPanel.add(LabelHpIcon);
        bottomPanel.add(LabelHptext);
        labelPlayerName.setForeground(Color.WHITE);
        labelPlayerNameValues.setForeground(Color.WHITE);
        labelThisLevelDestroyTank.setForeground(Color.WHITE);
        labelThisLevelDestroyTankValues.setForeground(Color.WHITE);
        labelThisLevelGetScore.setForeground(Color.WHITE);
        labelThisLevelGetScoreValues.setForeground(Color.WHITE);
        labelAllDestroyTank.setForeground(Color.WHITE);
        labelAllDestroyTankValues.setForeground(Color.WHITE);
        labelAllGetScore.setForeground(Color.WHITE);
        labelAllGetScoreValues.setForeground(Color.WHITE);
        LabelHpIcon.setForeground(Color.WHITE);
        LabelHptext.setForeground(Color.WHITE);

        JLabel background1=new JLabel(new ImageIcon("images/infobg.png"));
        background1.setBounds(0,0,230,176);
        JLabel background2=new JLabel(new ImageIcon("images/infobg.png"));
        background2.setBounds(0,0,230,176);

        topPanel.add(background1);
        middlePanel.add(background2);

        //添加组件
        add(topPanel);
        add(middlePanel);
        add(bottomPanel);
    }
    public class BottomPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(new ImageIcon("images/infobg.png").getImage(),0,0,230,176,null);
        }
    }
}
