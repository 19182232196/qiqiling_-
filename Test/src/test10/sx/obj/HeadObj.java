package test10.sx.obj;

import test10.sx.GameWin;
import test10.sx.utils.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class HeadObj extends GameObj{

    //方向 up down left right
    private String direction = "right";
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }

    public HeadObj(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);

        this.frame.addKeyListener(new KeyAdapter() {//键盘监听事件
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e);
            }
        });
    }

    public void changeDirection(KeyEvent e){//控制方向 w-up a-left d-right s-down
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                if (!"down".equals(direction)){
                    direction = "up";
                    img= GameUtils.upImg;
                }
                break;

            case KeyEvent.VK_S:
                if (!"up".equals(direction)){
                    direction = "down";
                    img= GameUtils.downImg;
                }
                break;

            case KeyEvent.VK_A:
                if (!"right".equals(direction)){
                    direction = "left";
                    img= GameUtils.leftImg;
                }
                break;

            case KeyEvent.VK_D:
                if (!"left".equals(direction)){
                    direction = "right";
                    img= GameUtils.rightImg;
                }
                break;

            default:
                break;
        }
    }

    public void move(){//移动

        List<BodyObj> bodyObjList=this.frame.bodyObjList;//身移动
        for (int i=bodyObjList.size()-1;i>=1;i--){
            bodyObjList.get(i).x=bodyObjList.get(i-1).x;
            bodyObjList.get(i).y=bodyObjList.get(i-1).y;
            if (this.x==bodyObjList.get(i).x&&this.y==bodyObjList.get(i).y){//头与身的碰撞判断
                GameWin.state=3;//失败
            }
        }
        bodyObjList.get(0).x=this.x;
        bodyObjList.get(0).y=this.y;

        switch (direction){//头移动
            case "up":
                y-=height;
                break;
            case "down":
                y+=height;
                break;
            case "left":
                x-=width;
                break;
            case "right":
                x+=width;
                break;
            default:
                break;
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        move();

        FoodObj food=this.frame.foodObj;//吃食物处理
        Integer newX=null;//最后一节坐标
        Integer newY=null;
        if (this.x==food.x&&this.y==food.y){
            this.frame.foodObj=food.getFood();
            BodyObj lastBody=this.frame.bodyObjList.get(this.frame.bodyObjList.size()-1);//获取最后一节元素
            newX=lastBody.x;
            newY=lastBody.y;

            this.frame.score++;//分数+1

        }

        if (this.frame.score>=15){// 通关判断
            GameWin.state=4;//通关
        }

        move();//move结束，新bodyObj对象添加bodyObjList
        if (newX!=null&&newY!=null){
            this.frame.bodyObjList.add(new BodyObj(GameUtils.bodyImg,newX,newY,this.frame));
        }

        if (x<0){//越界处理
            x=570;
        }else if (x>570){
            x=0;
        }else if (y<30){
            y=570;
        } else if (y>570) {
            y=30;
        }
    }
}