package com.tankwars.view.help;

import javax.swing.*;

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
        JLabel labelOperationHelp = new JLabel("<html>\n" +
                "  <h3>游戏玩法:<br></h1>\n" +
                "  <div style=\"font-size:10px;\">\n" +
                "    &emsp&emsp向上：W&emsp;&emsp;向下：S<br>\n" +
                "    <br>\n" +
                "    &emsp&emsp射击：J<br>\n" +
                "    <br>\n" +
                "    &emsp&emsp暂停：P&emsp;&emsp;继续：C\n" +
                "  </div>\n" +
                "</html>\n");
        labelOperationHelp.setHorizontalTextPosition(JLabel.CENTER);
        labelOperationHelp.setVerticalAlignment(JLabel.TOP);
        labelOperationHelp.setBounds(0, 0, 300, 600);
        add(labelOperationHelp);
    }
}
