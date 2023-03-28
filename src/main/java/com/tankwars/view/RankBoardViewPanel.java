package com.tankwars.view;

import com.tankwars.controller.Controller;

import javax.swing.*;
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
    JLabel scoreRankList;

    public RankBoardViewPanel(Controller controller) {
        setLayout(null);
        setSize(560, 560);
        scoreRankList = new JLabel();
        scoreRankList.setBounds(10, 0, 600, this.getHeight());
        scoreRankList.setHorizontalTextPosition(JLabel.CENTER);
        scoreRankList.setVerticalTextPosition(JLabel.CENTER);
        scoreRankList.setVerticalAlignment(JLabel.TOP);
        List<Map> scoreList = controller.getRankInfo();
        if (!scoreList.isEmpty()) {
            setScoreList(scoreList);
        }
        add(scoreRankList);
    }

    public void setScoreList(List scoreList) {
        String uiHtml = "<html>\n" +
                "<h1>总榜成绩排名:<br></h1>\n" +
                "<div style=\"font-size:20px;\">\n";
        if (scoreList != null) {
            ListIterator<Map> listIterator = scoreList.listIterator();
            int i = 1;
            while (listIterator.hasNext()) {
                Map key = listIterator.next();
                uiHtml = uiHtml + "<tr><td>" + i + "</td><td>玩家名:" + key.get("userName") + "</td><td>成绩:" + key.get("score") + "</td>" + "</tr>\n";
                i++;
            }
        }
        uiHtml = uiHtml +
                "  </div>\n" +
                "</html>";
        scoreRankList.setText(uiHtml);
    }
}
