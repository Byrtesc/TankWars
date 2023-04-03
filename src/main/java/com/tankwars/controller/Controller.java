package com.tankwars.controller;

import com.tankwars.model.Boom;
import com.tankwars.model.Bullet;
import com.tankwars.model.Scence;
import com.tankwars.model.obstacle.BirthPoint;
import com.tankwars.model.Tank;
import com.tankwars.model.obstacle.BaseObstacle;
import com.tankwars.utils.DBHelper;

import javax.swing.*;
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
    DBHelper dbHelper;
    public RefreshPanelTimer refreshPanelTimer;

    public Scence scence;
    //障碍物
    public List<BaseObstacle> walls;
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
    //爆炸效果
    public List<Boom> boomList;

    public int runTime = 6000;
    //敌方坦克生成时间 180*30=5.4秒
    public int generateTime = 180;
    //敌方坦克攻击时间 50*30=1.5秒
    public int attackTime = 50;

    public Controller() {
        dbHelper = new DBHelper();
        scence = new Scence(this);
//        walls=new ArrayList<>();
        enemyTanks = new ArrayList<>();
        playerTanks = new ArrayList<>();
        birthPoints = new ArrayList<>();
        bullets = new ArrayList<>();
        removeBullets = new ArrayList<>();
        boomList=new ArrayList<>();
        walls=scence.obstacleList.get(0);

        //设置出生点
        birthPoints.add(new BirthPoint(90, 10));
        birthPoints.add(new BirthPoint(450, 10));

        Tank tank1=new Tank(90, 475, 1, 3,3,"",this);
        Tank tank2=new Tank(450, 475, 1, 3,3,"",this);
        //我方坦克1
        playerTanks.add(tank1);
        playerTanks.add(tank2);

        //初始化定时器
        refreshPanelTimer = new RefreshPanelTimer(this);
    }

    public List<Map> getRankInfo() {
        dbHelper.initConnection();
        String sql = "select user.user_name,score,time from score inner join user on score.uid=user.id order by score desc limit 0,10";
        ResultSet resultSet = dbHelper.execQuery(sql);
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
            dbHelper.closeAll();
        }
        return null;
    }

    public List<Map> login(String userName) {
        dbHelper.initConnection();
        String sql = "select * from user where user_name='" + userName + "'";
        ResultSet resultSet = dbHelper.execQuery(sql);
        try {
            if (resultSet.next()) {
                int uid = resultSet.getInt("id");
                if (uid != 0) {
                    sql = "select score,time from score where uid='" + uid + "' order by score desc";
                    ResultSet resultSetScore = dbHelper.execQuery(sql);
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
                int result = dbHelper.execUpdate(sql);
                if (result > 0) {
                    System.out.println("注册成功");
                    JOptionPane.showMessageDialog(null, "欢迎新玩家:" + userName + "首次进入本游戏", "注册成功", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            return null;
        } catch (Exception ex) {
            System.out.println("数据库连接错误");
        } finally {
            dbHelper.closeAll();
        }
        return null;
    }
}
