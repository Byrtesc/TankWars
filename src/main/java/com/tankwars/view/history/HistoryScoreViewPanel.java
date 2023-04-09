package com.tankwars.view.history;

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
    JLabel scoreHistoryList;

    public HistoryScoreViewPanel() {
        setLayout(null);
        scoreHistoryList = new JLabel();
        scoreHistoryList.setBounds(0, 0, 560, 560);
        scoreHistoryList.setHorizontalTextPosition(JLabel.CENTER);
        scoreHistoryList.setVerticalTextPosition(JLabel.CENTER);
        scoreHistoryList.setVerticalAlignment(JLabel.TOP);

        add(scoreHistoryList);
    }

    public void setScoreList(List scoreList) {
        String uiHtml = "<html>\n" +
                "<h1>历史成绩:<br></h1>\n" +
                "<div style=\"font-size:20px;\">\n" +
                "<ul>\n";
        if (scoreList != null) {
            ListIterator<Map> listIterator = scoreList.listIterator();
            while (listIterator.hasNext()) {
                Map key = listIterator.next();
                uiHtml = uiHtml + "<li>成绩:" + key.get("score") + "&emsp;&emsp;&emsp;&emsp;时间:" + key.get("time") + "</li>\n";
            }
        }
        uiHtml = uiHtml + "</ul>\n" +
                "  </div>\n" +
                "</html>";
        scoreHistoryList.setText(uiHtml);
    }
}
