package com.tankwars.controller;

import com.tankwars.ai.AutomaticWayFinding;
import com.tankwars.controller.timer.AiTimer;
import com.tankwars.controller.timer.RefreshTimer;
import com.tankwars.model.*;
import com.tankwars.model.obstacles.BirthPoint;
import com.tankwars.model.obstacles.BaseObstacle;
import com.tankwars.model.obstacles.DiyBlock;
import com.tankwars.utils.DbUtil;
import com.tankwars.utils.MusicUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 2:45
 * @PackageName:com.tankwars.controller
 * @ClassName: Controller
 * @Description: TODO
 * @Version 1.0
 */
public class Controller {
    public MusicUtil musicUtil = new MusicUtil();
    public DbUtil dbUtil;
    public RefreshTimer refreshTimer;

    public Scence scence;
    //障碍物
    public List<BaseObstacle> walls;
    //路
    public List<BaseObstacle> roads;
    public List<BaseObstacle> homeIronWalls;
    public List<BaseObstacle> homeNormalWalls;
    public List<Items> items;
    //出生点
    public List<BirthPoint> birthPoints;
    //敌方坦克组
    public List<Tank> enemyTanks;
    //我方坦克组
    public List<Tank> playerTanks;
    //子弹组
    public List<Bullet> bullets;
    //子弹壳组
    public List<Bullet> removeBullets;
    public List<Items> removeItems;
    //爆炸效果
    public List<Boom> boomList;

    public int runTime = 6000;

    public int generateTime = 300;//敌方坦克生成时间 300*10=3000毫秒

    public int attackTime = 80;//敌方坦克攻击时间 80*10=800毫秒
    //随即道具时间
    public int ranItemsTime = 1000;
    public int itemDisappearTime = 500;

    public int selectedMap = 0;//地图下标
    public int playerNum = 1;//玩家数量
    public int needEnemyTankNum = 20;//每关敌方上限数量
    public int nowStageEnemyTankNum = 0;//当前坦克数量
    public int nowEnemyspeed = 0;//自定义坦克速度

    public int nowScore = 0;//当前关卡分数
    public int allScore = 0;//所有关卡分数
    public int nowDesTankNum = 0;//当前击毁坦克数量
    public int allDesTankNum = 0;//所有击毁坦克数量

    public int whiteTankNum = 0;//白色坦克数量
    public int yellowTankNum = 0;//黄色坦克数量
    public int greenTankNum = 0;//绿色坦克数量
    public int blueTankNum = 0;//蓝色坦克数量
    public int redTankNum = 0;//红色坦克数量

    public int nowWhiteTankNum = 0;//现在白色坦克数量
    public int nowYellowTankNum = 0;//现在黄色坦克数量
    public int nowGreenTankNum = 0;//现在绿色坦克数量
    public int nowBlueTankNum = 0;//现在蓝色坦克数量
    public int nowRedTankNum = 0;//现在红色坦克数量

    public boolean isStart = false;
    public boolean playerTankPowerBuff = false;
    public boolean ironHomeWallBuff = false;
    public int resetTankPowerBuffTime = 3000;
    public int resetironHomeWallTime = 3000;

    public Tank playerTank1;
    public Tank playerTank2;
    public int playerTankHp;
    public int playerHomeHp;
    public boolean customModel=false;
    public boolean diyModel=false;
    public boolean diyGameIsStart=false;
    public DiyBlock diyBlock;
    public Rectangle homeRectangle = new Rectangle(250, 475, 50, 50);

    public List<BaseObstacle> diyMapObstacleList;

    public AutomaticWayFinding awf;
    public Tank enemyAiTank;
    public boolean aiMode=false;
    public AiTimer aiTimer;
    public List<Point> movePath;

    public Controller() {
        dbUtil = new DbUtil();
        movePath=new ArrayList<>();
        homeIronWalls = new ArrayList<>();
        homeNormalWalls = new ArrayList<>();
        scence = new Scence(this);
        enemyTanks = new ArrayList<>();
        playerTanks = new ArrayList<>();
        birthPoints = new ArrayList<>();
        bullets = new ArrayList<>();
        removeBullets = new ArrayList<>();
        boomList = new ArrayList<>();
        roads = new ArrayList<>();
        items = new ArrayList<>();
        removeItems = new ArrayList<>();
        diyMapObstacleList=new ArrayList<>();
        walls=new ArrayList<>();
        //设置出生点
        birthPoints.add(new BirthPoint(90, 10));
        birthPoints.add(new BirthPoint(450, 10));

        awf=new AutomaticWayFinding();
        //初始化定时器
        refreshTimer = new RefreshTimer(this);
        aiTimer = new AiTimer(this);
    }

    //更新关卡后更新游戏数据
    public void updateGameNewData() {
        nowWhiteTankNum = 0;//现在白色坦克数量
        nowYellowTankNum = 0;//现在黄色坦克数量
        nowGreenTankNum = 0;//现在绿色坦克数量
        nowBlueTankNum = 0;//现在蓝色坦克数量
        nowRedTankNum = 0;//现在红色坦克数量
        playerHomeHp = 1;//家的生命
        //遍历
        for (Integer i : scence.tankTypeList.get(selectedMap)) {
            switch (i.intValue()) {
                case 1:
                    nowWhiteTankNum++;
                    break;
                case 2:
                    nowYellowTankNum++;
                    break;
                case 3:
                    nowGreenTankNum++;
                    break;
                case 4:
                    nowBlueTankNum++;
                    break;
                case 5:
                    nowRedTankNum++;
                    break;
            }
        }
        scence.updateMapData();
        playerTanks.clear();
        bullets.clear();
        boomList.clear();
        walls = scence.obstacleList.get(selectedMap);
        walls.addAll(homeNormalWalls);
        playerTank1 = new Tank(90, 475, 1, 3, 3, "", this);
        //我方坦克1
        this.playerTankHp=playerTank1.hp;
        playerTanks.add(playerTank1);
        System.out.println(playerNum);
        if (playerNum == 2) {
            playerTank2 = new Tank(450, 475, 1, 3, 3, "", this);
            playerTanks.add(playerTank2);
        }

        items.clear();
        enemyTanks.clear();
        nowStageEnemyTankNum = 0;
    }

    public int saveRankScore(String userName ,int score){
        dbUtil.initConnection();
        String sql = "select * from user where user_name='" + userName + "'";
        ResultSet resultSet = dbUtil.execQuery(sql);
        int uid=0;
        try{
            if (resultSet.next()){
                uid=resultSet.getInt("id");
            }else {
                return 0;
            }
            System.out.println("存入用户"+userName+" id:"+uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        sql="insert into score (score,uid) values ("+score+","+uid+")";
        int result=dbUtil.execUpdate(sql);
        return result;
    }
    public List<Map> getRankInfo() {
        dbUtil.initConnection();
        String sql = "select user.user_name,score,time from score inner join user on score.uid=user.id order by score desc limit 0,10";
        ResultSet resultSet = dbUtil.execQuery(sql);
        try {
            List<Map> scoreList = new ArrayList<>();
            while (resultSet.next()) {
                Map map = new HashMap();
                map.put("userName", resultSet.getString("user_name"));
                map.put("score", resultSet.getInt("score"));
                map.put("time", String.valueOf(resultSet.getDate("time")));
                scoreList.add(map);
            }
            System.out.println(scoreList);
            return scoreList;
        } catch (Exception ex) {

        } finally {
            dbUtil.closeAll();
        }
        return null;
    }

    public List<Map> login(String userName) {
        dbUtil.initConnection();
        String sql = "select * from user where user_name='" + userName + "'";
        ResultSet resultSet = dbUtil.execQuery(sql);
        try {
            if (resultSet.next()) {
                int uid = resultSet.getInt("id");
                if (uid != 0) {
                    sql = "select score,time from score where uid='" + uid + "' order by score desc";
                    ResultSet resultSetScore = dbUtil.execQuery(sql);
                    List<Map> list = new ArrayList<>();
                    while (resultSetScore.next()) {
                        Map map = new HashMap();
                        map.put("score", resultSetScore.getInt("score"));
                        map.put("time", String.valueOf(resultSetScore.getDate("time")));
                        list.add(map);
                    }
                    return list;
                }
            } else {
                sql = "insert into user(user_name) values ('" + userName + "')";
                System.out.println(sql);
                int result = dbUtil.execUpdate(sql);
                if (result > 0) {
                    System.out.println("注册成功");
                    JOptionPane.showMessageDialog(null, "欢迎新玩家:" + userName + "首次进入本游戏", "注册成功", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            return null;
        } catch (Exception ex) {
            System.out.println("数据库连接错误");
        } finally {
            dbUtil.closeAll();
        }
        return null;
    }
}
