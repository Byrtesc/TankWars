package com.tankwars.utils;

import java.sql.*;

/**
 * @Author yangmingquan
 * @Date 2023/3/26 2:12
 * @PackageName:com.tankwars.utils
 * @ClassName: DBHelper
 * @Description: 打包数据库操作
 * @Version 1.0
 */
public class DbUtil {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    private String connectionUrl = "jdbc:mysql://localhost:3306/jx230219?useSSL=false";
    private String connectionUser = "root";
    private String connectionPassword = "123456";

    /**
     * 查询并返回数据集
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet execQuery(String sql) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 增删改，返回结果
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public int execUpdate(String sql) {
        int result = 0;
        try {
            statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * 传参关闭连接
     *
     * @param resultSet
     * @param statement
     * @param connection
     * @throws SQLException
     */
    public void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("数据连接关闭异常");
        }
    }

    /**
     * 无参关闭全部连接
     *
     * @throws SQLException
     */
    public void closeAll() {
        try {
            this.resultSet.close();
            this.statement.close();
            this.connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("数据连接关闭异常");
        }
    }

    /**
     * 初始化连接
     *
     * @throws SQLException
     */
    public void initConnection() {
        try {
            connection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("数据库连接初始化失败");
        }
    }
}
