package com.tankwars.view.rank;

import com.tankwars.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 * @Author yangmingquan
 * @Date 2023/3/26 16:51
 * @PackageName:com.tankwars.view
 * @ClassName: RankBoardViewPanel
 * @Description: TODO
 * @Version 1.0
 */
public class RankBoardViewPanel extends JPanel {
    GridBagLayout gridBagLayout;
    public RankBoardViewPanel(Controller controller) {
        gridBagLayout=new GridBagLayout();
        setLayout(gridBagLayout);
        setSize(500, 560);
        List<Map> scoreList = controller.getRankInfo();
        if (!scoreList.isEmpty()) {
            setScoreList(scoreList);
        }

    }
    public void setScoreList(List scoreList) {
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.insets=new Insets(10,10,10,10);
        JLabel labelTmp=new JLabel();
        JLabel labelTmp1=new JLabel();
        JLabel labelTmp2=new JLabel();
        JLabel labelTmp3=new JLabel();
        JLabel labelTmp4=new JLabel();
        labelTmp.setHorizontalAlignment(JLabel.CENTER);
        labelTmp1.setHorizontalAlignment(JLabel.CENTER);
        labelTmp2.setHorizontalAlignment(JLabel.CENTER);
        labelTmp3.setHorizontalAlignment(JLabel.CENTER);
        labelTmp4.setHorizontalAlignment(JLabel.CENTER);
        labelTmp.setFont(new Font(Font.DIALOG, 1, 56));
        labelTmp1.setFont(new Font(Font.DIALOG, 1, 20));
        labelTmp2.setFont(new Font(Font.DIALOG, 1, 20));
        labelTmp3.setFont(new Font(Font.DIALOG, 1, 20));
        labelTmp4.setFont(new Font(Font.DIALOG, 1, 20));
        labelTmp.setText("排行榜");
        labelTmp1.setText("排名");
        labelTmp2.setText("姓名");
        labelTmp3.setText("成绩");
        labelTmp4.setText("时间");

        labelTmp.setForeground(Color.white);
        labelTmp1.setForeground(Color.white);
        labelTmp2.setForeground(Color.white);
        labelTmp3.setForeground(Color.white);
        labelTmp4.setForeground(Color.white);
        gbc.gridwidth=0;
        gridBagLayout.setConstraints(labelTmp,gbc);
        gbc.gridwidth=1;
        gridBagLayout.setConstraints(labelTmp1,gbc);
        gridBagLayout.setConstraints(labelTmp2,gbc);
        gbc.gridwidth=0;
        gridBagLayout.setConstraints(labelTmp3,gbc);

//        gridBagLayout.setConstraints(labelTmp4,gbc);
        this.add(labelTmp);
        this.add(labelTmp1);
        this.add(labelTmp2);
        this.add(labelTmp3);
//        this.add(labelTmp4);


        if (scoreList != null) {
            ListIterator<Map> listIterator = scoreList.listIterator();
            int i = 1;
            while (listIterator.hasNext()) {
                gbc.gridwidth=1;
                Map map = listIterator.next();
                JLabel labelTmpRankding=new JLabel();
                JLabel labelTmpName=new JLabel();
                JLabel labelTmpScore=new JLabel();
                JLabel labelTmpDatetime=new JLabel();

                labelTmpRankding.setFont(new Font(Font.DIALOG, 1, 20));
                labelTmpName.setFont(new Font(Font.DIALOG, 1, 20));
                labelTmpScore.setFont(new Font(Font.DIALOG, 1, 20));
                labelTmpDatetime.setFont(new Font(Font.DIALOG, 1, 20));

                labelTmpRankding.setHorizontalAlignment(JLabel.CENTER);
                labelTmpName.setHorizontalAlignment(JLabel.CENTER);
                labelTmpScore.setHorizontalAlignment(JLabel.CENTER);
                labelTmpDatetime.setHorizontalAlignment(JLabel.CENTER);

                labelTmpRankding.setForeground(Color.WHITE);
                labelTmpName.setForeground(Color.WHITE);
                labelTmpScore.setForeground(Color.WHITE);
                labelTmpDatetime.setForeground(Color.WHITE);

                labelTmpRankding.setText(i+"");
                labelTmpName.setText(map.get("userName").toString());
                labelTmpScore.setText(map.get("score").toString());
                labelTmpDatetime.setText(map.get("time").toString());
                gridBagLayout.setConstraints(labelTmpRankding,gbc);
                gridBagLayout.setConstraints(labelTmpName,gbc);
                gbc.gridwidth=0;
                gridBagLayout.setConstraints(labelTmpScore,gbc);

//                gridBagLayout.setConstraints(labelTmpDatetime,gbc);
                this.add(labelTmpRankding);
                this.add(labelTmpName);
                this.add(labelTmpScore);
//                this.add(labelTmpDatetime);
                i++;
            }
        }




    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("images/historyandrank.png").getImage(),0,0,500,700,null);
    }
}
