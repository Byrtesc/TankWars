package com.tankwars.view.history;

import com.tankwars.controller.Controller;
import com.tankwars.view.UI;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 * @Author yangmingquan
 * @Date 2023/3/26 16:51
 * @PackageName:com.tankwars.view
 * @ClassName: HistoryScoreViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class HistoryScoreViewPanel extends JPanel {
    JLabel scoreHistoryLabel;
    JLabel scoreHistoryLabel1;
    GridBagLayout gridBagLayout;
    GridBagConstraints gbc ;
    List scoreList;

    public HistoryScoreViewPanel(List scoreList,Controller controller) {
        gridBagLayout = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.insets=new Insets(10,10,10,10);


        JLabel scoreHistoryLabel0 = new JLabel("历史记录");
        scoreHistoryLabel0.setHorizontalAlignment(JLabel.CENTER);

        scoreHistoryLabel = new JLabel("成绩");
        scoreHistoryLabel.setHorizontalAlignment(JLabel.CENTER);

        scoreHistoryLabel1 = new JLabel("时间");
        scoreHistoryLabel1.setHorizontalAlignment(JLabel.CENTER);
        scoreHistoryLabel0.setFont(new Font(Font.DIALOG, 1, 50));
        scoreHistoryLabel.setFont(new Font(Font.DIALOG, 1, 20));
        scoreHistoryLabel1.setFont(new Font(Font.DIALOG, 1, 20));

        scoreHistoryLabel0.setForeground(Color.WHITE);
        scoreHistoryLabel.setForeground(Color.WHITE);
        scoreHistoryLabel1.setForeground(Color.WHITE);

        gbc.gridwidth=0;
        gridBagLayout.setConstraints(scoreHistoryLabel0,gbc);
        gbc.gridwidth=1;
        gridBagLayout.setConstraints(scoreHistoryLabel,gbc);
        gbc.gridwidth=0;
        gridBagLayout.setConstraints(scoreHistoryLabel1,gbc);

        add(scoreHistoryLabel0);
        add(scoreHistoryLabel);
        add(scoreHistoryLabel1);
        setLayout(gridBagLayout);

    }

    public void setScoreList(List scoreList) {
        this.scoreList=scoreList;

        if (scoreList != null) {
            ListIterator<Map> listIterator = scoreList.listIterator();
            while (listIterator.hasNext()) {
                Map key = listIterator.next();
                gbc.gridwidth=1;
                JLabel labelTmpScore=new JLabel();
                JLabel labelTmpDatetime=new JLabel();
                labelTmpScore.setFont(new Font(Font.DIALOG, 1, 20));
                labelTmpDatetime.setFont(new Font(Font.DIALOG, 1, 20));
                labelTmpScore.setHorizontalAlignment(JLabel.CENTER);
                labelTmpDatetime.setHorizontalAlignment(JLabel.CENTER);
                labelTmpScore.setText(key.get("score")+"");
                labelTmpDatetime.setText(key.get("time")+"");
                labelTmpScore.setForeground(Color.WHITE);
                labelTmpDatetime.setForeground(Color.WHITE);

                gridBagLayout.setConstraints(labelTmpScore,gbc);
                gbc.gridwidth=0;
                gridBagLayout.setConstraints(labelTmpDatetime,gbc);

                this.add(labelTmpScore);
                this.add(labelTmpDatetime);
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("images/historyandrank.png").getImage(),0,0,500,700,null);
    }
}
