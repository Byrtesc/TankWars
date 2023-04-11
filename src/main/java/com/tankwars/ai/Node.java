package com.tankwars.ai;

import com.tankwars.model.Tank;
import com.tankwars.model.obstacles.BaseObstacle;

/**
 * @Author yangmingquan
 * @Date 2023/4/10 16:53
 * @PackageName:com.tankwars.ai
 * @ClassName: Node
 * @Description: TODO
 * @Version 1.0
 */
public class Node {
    public int piexlSize=25;
    public int x;
    public int y;
    public int F;//权值
    public int G;//出发点到该点
    public int H;//该点到目标点

    public Node parentNode;//父节点

    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Node(int x,int y,Node parentNode){
        this.x=x;
        this.y=y;
        this.parentNode=parentNode;
    }

    public Node(Tank tank){
        this.x=tank.x/piexlSize;
        this.y=tank.y/piexlSize;
    }

    public Node(BaseObstacle obstacle){
        this.x=obstacle.x/piexlSize;
        this.y=obstacle.y/piexlSize;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Node)obj).x==this.x&&((Node)obj).y==this.y){
            return true;
        }else {
            return false;
        }
    }
}
