package com.tankwars.controller;

import com.tankwars.controller.timers.RefreshPanelTimer;
import com.tankwars.model.Maps;
import com.tankwars.model.tanks.Tank;
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
    public Maps maps;
    public Tank tank;
    public List<Tank> enemyTanks;
    public List<Tank> playerTanks;
    public int runTime=6000;

    public Controller() {
        enemyTanks=new ArrayList<>();
        playerTanks=new ArrayList<>();

        playerTanks.add(new Tank(90, 475, 1, 3));
        enemyTanks.add(new Tank(90, 10, 1, 3));
        enemyTanks.add(new Tank(405, 475, 1, 3));

        maps = new Maps();
        refreshPanelTimer = new RefreshPanelTimer(this, enemyTanks,playerTanks);
        dbHelper = new DBHelper();

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
