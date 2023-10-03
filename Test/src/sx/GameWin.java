package test10.sx;

import test10.sx.obj.BodyObj;
import test10.sx.obj.FoodObj;
import test10.sx.obj.HeadObj;
import test10.sx.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame {

    public static int state=0;//游戏状态 0-未开始 1-游戏中 2-暂停 3-失败 4-通关 5-失败重开

    public int score=0;//分数

    Image offScreenImage=null;//定义双缓存图片

    int winWidth=800;//窗口宽高
    int winHeight=600;

    HeadObj headObj=new HeadObj(GameUtils.rightImg,60,570,this);//头的对象

    public List<BodyObj> bodyObjList=new ArrayList<>();//身的集合

    public FoodObj foodObj=new FoodObj().getFood();//食物对象

    public void launch(){//窗口设置
        this.setVisible(true);//是否可见
        this.setSize(winWidth,winHeight);//大小
        this.setTitle("贪吃蛇学习");//标题

        bodyObjList.add(new BodyObj(GameUtils.bodyImg,30,570,this));//身的初始化
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,0,570,this));

        this.addKeyListener(new KeyAdapter() {//键盘事件
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_SPACE){
                    switch (state){
                        case 0://未开始
                            state=1;
                            break;

                        case 1://游戏中
                            state=2;
                            repaint();
                            break;

                        case 2://暂停
                            state=1;
                            break;

                        case 3://失败重开
                            state=5;
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        while (true){
            if (state==1){//游戏中才调用
                repaint();
            }

            if (state==5){//失败重开
                state=0;
                reGame();
            }

            try {
                Thread.sleep(270);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {

        if (offScreenImage==null){//初始化双缓存图片
            offScreenImage=this.createImage(winWidth,winHeight);
        }
        Graphics gImage=offScreenImage.getGraphics();//获取图片对应graphics对象

        gImage.setColor(Color.gray);//灰色背景
        gImage.fillRect(0,0,winWidth,winHeight);

        gImage.setColor(Color.red);//网格线
        for (int i=0;i<=20;i++){
            gImage.drawLine(0,i*30,600,i*30);//横线
            gImage.drawLine(i*30,0,i*30,600);//竖线
        }

        for (int i=bodyObjList.size()-1;i>=0;i--){//绘制身
            bodyObjList.get(i).paintSelf(gImage);
        }

        headObj.paintSelf(gImage);//绘制头

        foodObj.paintSelf(gImage);//绘制食物

        GameUtils.drawWord(gImage,score+"分",Color.black,50,650,300);//分数绘制

        gImage.setColor(Color.gray);//绘制提示语
        prompt(gImage);

        g.drawImage(offScreenImage,0,0,null);//将双缓存图片绘制在主窗口
    }

    void prompt(Graphics g){//绘制提示语
        if (state==0){//未开始
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"按下空格开始",Color.black,35,150,290);
        }

        if (state==2){//暂停
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"停止,按下空格继续",Color.white,35,150,290);
        }

        if (state==4){//通关
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"通关",Color.green,35,150,290);
        }

        if (state==3){//失败
            g.fillRect(120,240,400,70);
            GameUtils.drawWord(g,"失败,按下空格重开",Color.red,35,150,290);
        }
    }

    void reGame(){//游戏重置
        this.dispose();//关闭当前窗口

        String[] re={};//开一个新窗口
        main(re);
    }

    public static void main(String[] args){
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
