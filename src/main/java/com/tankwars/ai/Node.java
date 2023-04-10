package com.tankwars.ai;

/**
 * @Author yangmingquan
 * @Date 2023/4/10 16:53
 * @PackageName:com.tankwars.ai
 * @ClassName: Node
 * @Description: TODO
 * @Version 1.0
 */
public class Node {
    public int piexlSize=50;
    public int x;
    public int y;
    public int F;//权值
    public int G;//出发点到该点
    public int H;//该点到目标点

    public Node preNode;//父节点

    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Node(int x,int y,Node preNode){
        this.x=x;
        this.y=y;
        this.preNode=preNode;
    }
}
