package com.tankwars.ai;

import com.tankwars.model.Tank;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.OPCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangmingquan
 * @Date 2023/4/10 16:53
 * @PackageName:com.tankwars.ai
 * @ClassName: FindWay
 * @Description: TODO
 * @Version 1.0
 */
public class FindWay {//550*530
    public Node beginNode = null;
    public Node endNode = null;

    public List<Node> getWayLine(Tank tank, Tank enemyTank) {
        List<Node> wayList = new ArrayList<>();
        List<Node> tmpList = null;

        beginNode = new Node(enemyTank);
        beginNode.G = 0;
        endNode = new Node(tank);

        //获取四周扩散节点
        tmpList = aroundNode(beginNode);
        //判定是否有获得到扩散节点
        if (tmpList == null || tmpList.size() == 0) {
            return wayList;
        }
        //把扩散节点放入openlist
        TestMain.openList.addAll(tmpList);

        for (int i = 0; i < TestMain.openList.size(); i++) {
            //继续获取扩散节点
            Node tmpNode = TestMain.openList.get(i);
            tmpList = aroundNode(tmpNode);
            if (tmpList == null || tmpList.size() == 0) {
                continue;
            }
            //找到目标节点，添加入closedList
            if (tmpList.contains(endNode)) {
                for (Node node : tmpList) {
                    if (node.equals(endNode)) {
                        TestMain.closedList.add(node);
                        break;
                    }
                }
                break;
            }
            for (Node node : tmpList) {
                if (TestMain.openList.contains(node)) {
                    for (Node openListNode : TestMain.openList) {
                        if (openListNode.equals(node)) {
                            if (openListNode.G > node.G) {
                                openListNode.G = node.G;
                                openListNode.F = openListNode.G + openListNode.H;
                                openListNode.parentNode = node.parentNode;
                                break;
                            }
                        }
                    }
                } else {
                    TestMain.openList.add(node);
                }

            }

            TestMain.openList.remove(i);
            i--;
        }
        //从closedList里获取路线
        for(int i = 0; i < TestMain.closedList.size(); i++){
            //如果wayList<=0,说明还没有获取到第一个方块(终点)；如果wayList>0,说明已经获取到第一个方块(终点)，则不用再执行下一个if语句
            if(wayList.size() > 0){
                if(wayList.get(wayList.size() - 1).parentNode.equals(TestMain.closedList.get(i))){
                    wayList.add(TestMain.closedList.get(i));
                    //如果获取到的方块是起点，则跳出for循环
                    if(TestMain.closedList.get(i).equals(beginNode)){
                        break;
                    }
                    //获取到一个方块后，将该方块从closedlist中删除，然后从0开始遍历closedlist找到第一个方块的parentNode。
                    //所以需要赋值i=-1,因为continue的时候会执行一次i++
                    TestMain.closedList.remove(TestMain.closedList.get(i));
                    i = -1;

                }
                continue;
            }

            //第一个方块为终点，获取到一个方块后，将该方块从closedlist中删除，然后从0开始遍历closedlist找到第一个方块的parentNode。
            //所以需要赋值i=-1,因为continue的时候会执行一次i++
            if(TestMain.closedList.get(i).equals(endNode)){
                wayList.add(TestMain.closedList.get(i));
                TestMain.closedList.remove(TestMain.closedList.get(i));
                i = -1;
                continue;
            }
        }

        return wayList;
    }

    public List<Node> aroundNode(Node node) {
        if (node.x == 20 && node.y == 21) {
            System.out.println("越界");
        }
        List<Node> list = new ArrayList<>();
        //上方节点
        if (node.y - 1 >= 0) {
            Node tmpNode = new Node(node.x, node.y - 1, node);
            //不是障碍物和已经计算过的节点，加入队列
            if (!TestMain.obstaclesList.contains(tmpNode) && !TestMain.closedList.contains(tmpNode)) {
                list.add(tmpNode);
            }
        }
        //下方节点
        if (node.y + 1 < 22) {
            Node tmpNode = new Node(node.x, node.y + 1, node);
            //不是障碍物和已经计算过的节点，加入队列
            if (!TestMain.obstaclesList.contains(tmpNode) && !TestMain.closedList.contains(tmpNode)) {
                list.add(tmpNode);
            }
        }
        //左方节点
        if (node.x - 1 >= 0) {
            Node tmpNode = new Node(node.x - 1, node.y, node);
            //不是障碍物和已经计算过的节点，加入队列
            if (!TestMain.obstaclesList.contains(tmpNode) && !TestMain.closedList.contains(tmpNode)) {
                list.add(tmpNode);
            }
        }
        //右方节点
        if (node.x + 1 < 20) {
            Node tmpNode = new Node(node.x + 1, node.y, node);
            //不是障碍物和已经计算过的节点，加入队列
            if (!TestMain.obstaclesList.contains(tmpNode) && !TestMain.closedList.contains(tmpNode)) {
                list.add(tmpNode);
            }
        }

        TestMain.closedList.add(node);
        getFGH(list, node);
        return list;
    }

    public void getFGH(List<Node> nodeList, Node currentNode) {
        if (nodeList != null && nodeList.size() > 0) {
            for (Node node : nodeList) {
                node.G = currentNode.G + 1;
                node.H = toGetH(node, endNode);
                node.F = node.G + node.H;
            }
        }
    }

    public int toGetH(Node currentNode, Node targetNode) {
        int h = 0;
        h += Math.abs(currentNode.x - targetNode.x);
        h += Math.abs(currentNode.y - targetNode.y);
        return h;
    }
}
