package com.tankwars.view;

import com.tankwars.controller.Controller;

/**
 * @Author yangmingquan
 * @Date 2023/3/25 21:05
 * @PackageName:com.tankwars.view
 * @ClassName: UI
 * @Description: TODO
 * @Version 1.0
 */
public class UI {
    public static WelcomeView welcomeView;
    public static MainGameView mainGameView;
    public static HistoryScoreView historyScoreView;
    public static CalculateScoreView calculateScoreView;
    public static RankBoardView rankBoardView;
    public static HelpTipsView helpTipsView;
    public static CustomSettingView customSettingView;
    public static final String GAME_AUTHOR_NAME = "坦克大战       姓名:杨铭泉       班级:JX2302       学号:JX230219";
    public UI(Controller controller) {
        welcomeView =new WelcomeView(controller);
        mainGameView = new MainGameView(controller);
        historyScoreView=new HistoryScoreView();
        calculateScoreView=new CalculateScoreView();
        rankBoardView=new RankBoardView(controller);
        helpTipsView=new HelpTipsView();
        customSettingView=new CustomSettingView(controller);
    }
}
