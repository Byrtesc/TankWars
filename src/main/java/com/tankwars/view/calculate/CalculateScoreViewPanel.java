package com.tankwars.view.calculate;

import javax.swing.*;
import java.awt.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 18:05
 * @PackageName:com.tankwars.view
 * @ClassName: CalculateScoreViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class CalculateScoreViewPanel extends JPanel {
    public JLabel labelWhiteTank;
    public JLabel labelYellowTank;
    public JLabel labelGreenTank;
    public JLabel labelBlueTank;
    public JLabel labelRedTank;
    public JLabel labelStage;

    public JLabel labelWhiteTankTotalValues;
    public JLabel labelYellowTankTotalValues;
    public JLabel labelGreenTankTotalValues;
    public JLabel labelBlueTankTotalValues;
    public JLabel labelRedTankTotalValues;
    public JLabel labelTankTotalValues;
    public JLabel labelScoreTotalValues;

    public CalculateScoreViewPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        labelStage = new JLabel("关卡:0");
        labelWhiteTank = new JLabel("  0 ");
        labelYellowTank = new JLabel("  0 ");
        labelGreenTank = new JLabel("  0 ");
        labelBlueTank = new JLabel("  0 ");
        labelRedTank = new JLabel("  0 ");

        labelWhiteTankTotalValues = new JLabel(" X  100  =  0");
        labelYellowTankTotalValues = new JLabel(" X  200  =  0");
        labelGreenTankTotalValues = new JLabel(" X  200  =  0");
        labelBlueTankTotalValues = new JLabel(" X  300  =  0");
        labelRedTankTotalValues = new JLabel(" X  500  =  0");
        labelTankTotalValues = new JLabel("坦克总数:0");
        labelScoreTotalValues = new JLabel("    总积分:0");

        labelWhiteTank.setIcon(new ImageIcon("images/whiteTank.png"));
        labelYellowTank.setIcon(new ImageIcon("images/yellowTank.png"));
        labelGreenTank.setIcon(new ImageIcon("images/greenTank.png"));
        labelBlueTank.setIcon(new ImageIcon("images/blueTank.png"));
        labelRedTank.setIcon(new ImageIcon("images/redTank.png"));

        labelStage.setFont(new Font(Font.DIALOG, 1, 30));
        labelWhiteTank.setFont(new Font(Font.DIALOG, 1, 30));
        labelYellowTank.setFont(new Font(Font.DIALOG, 1, 30));
        labelGreenTank.setFont(new Font(Font.DIALOG, 1, 30));
        labelBlueTank.setFont(new Font(Font.DIALOG, 1, 30));
        labelRedTank.setFont(new Font(Font.DIALOG, 1, 30));
        labelWhiteTankTotalValues.setFont(new Font(Font.DIALOG, 1, 30));
        labelYellowTankTotalValues.setFont(new Font(Font.DIALOG, 1, 30));
        labelGreenTankTotalValues.setFont(new Font(Font.DIALOG, 1, 30));
        labelBlueTankTotalValues.setFont(new Font(Font.DIALOG, 1, 30));
        labelRedTankTotalValues.setFont(new Font(Font.DIALOG, 1, 30));
        labelTankTotalValues.setFont(new Font(Font.DIALOG, 1, 30));
        labelScoreTotalValues.setFont(new Font(Font.DIALOG, 1, 30));

        labelStage.setForeground(Color.WHITE);
        labelWhiteTank.setForeground(Color.WHITE);
        labelYellowTank.setForeground(Color.WHITE);
        labelGreenTank.setForeground(Color.WHITE);
        labelBlueTank.setForeground(Color.WHITE);
        labelRedTank.setForeground(Color.WHITE);
        labelWhiteTankTotalValues.setForeground(Color.WHITE);
        labelYellowTankTotalValues.setForeground(Color.WHITE);
        labelGreenTankTotalValues.setForeground(Color.WHITE);
        labelBlueTankTotalValues.setForeground(Color.WHITE);
        labelRedTankTotalValues.setForeground(Color.WHITE);
        labelTankTotalValues.setForeground(Color.WHITE);
        labelScoreTotalValues.setForeground(Color.WHITE);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gridBagLayout.setConstraints(labelStage, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelWhiteTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelWhiteTankTotalValues, gbc);

        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelYellowTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelYellowTankTotalValues, gbc);

        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelGreenTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelGreenTankTotalValues, gbc);

        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelBlueTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelBlueTankTotalValues, gbc);

        gbc.gridwidth = 1;
        gridBagLayout.setConstraints(labelRedTank, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelRedTankTotalValues, gbc);


        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelTankTotalValues, gbc);
        gbc.gridwidth = 0;
        gridBagLayout.setConstraints(labelScoreTotalValues, gbc);

        setLayout(gridBagLayout);
        add(labelStage);
        add(labelWhiteTank);
        add(labelWhiteTankTotalValues);

        add(labelYellowTank);
        add(labelYellowTankTotalValues);

        add(labelGreenTank);
        add(labelGreenTankTotalValues);

        add(labelBlueTank);
        add(labelBlueTankTotalValues);

        add(labelRedTank);
        add(labelRedTankTotalValues);

        add(labelTankTotalValues);
        add(labelScoreTotalValues);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("images/historyandrank.png").getImage(),0,0,500,700,null);
    }
}
