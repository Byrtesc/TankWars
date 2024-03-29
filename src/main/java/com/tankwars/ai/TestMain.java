package com.tankwars.ai;

import com.tankwars.controller.Controller;
import com.tankwars.model.Scence;
import com.tankwars.model.Tank;
import com.tankwars.model.obstacles.BaseObstacle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/4/10 23:23
 * @PackageName:com.tankwars.ai
 * @ClassName: TestMain
 * @Description: TODO
 * @Version 1.0
 */
public class TestMain {
    public static List<Node> obstaclesList=new ArrayList<>();
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scence scence = new Scence(controller);
        scence.updateMapData();
        for (BaseObstacle baseObstacle:scence.obstacleList.get(7)) {
            System.out.println(baseObstacle.getClass().getName());
            if (!baseObstacle.getClass().getName().equals("com.tankwars.model.obstacles.Woods")){
                obstaclesList.add(new Node(baseObstacle));
            }
        }
        for (BaseObstacle obstacle:controller.homeNormalWalls) {
            obstaclesList.add(new Node(obstacle));
        }
        AutomaticWayFinding automaticWayFinding =new AutomaticWayFinding();
        automaticWayFinding.obstaclesList=obstaclesList;
        Tank tank = new Tank(475,475,3,1,1,"tank",controller);
        Tank enemyTank = new Tank(25,25,1,1,1,"tank",controller);
        List<Node> wayLine= automaticWayFinding.getWayLine(tank,enemyTank);
        for (Node node:wayLine){
            System.out.println(node.x+" "+node.y);
        }
    }
}
