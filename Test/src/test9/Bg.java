package test9;

import java.awt.*;

public class Bg {

    static int level=1;//关卡
    int goal=level*3;

    static int count=0;//分数

    static int waterNum=3;//药水
    int price= (int) (Math.random()*10);
    boolean shop=false;
    static boolean waterFlag=false;

    long startTime;//计时
    long endTime;

    Image bg= Toolkit.getDefaultToolkit().getImage("imgs/bg.png");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("imgs/bg1.png");
    Image peo = Toolkit.getDefaultToolkit().getImage("imgs/peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("imgs/water.png");

    public void paintSelf(Graphics g){//绘制
        g.drawImage(bg1,0,0,null);
        g.drawImage(bg,0,200,null);

        switch (GameWin.state){
            case 0:
                drawWord(g,80,Color.BLACK,"右键开始",100,450);
                break;

            case 1:
                g.drawImage(peo,310,50,null);

                drawWord(g,10,Color.BLACK,"积分"+count,30,150);

                g.drawImage(water,140,40,null);//药水组件
                drawWord(g,10,Color.BLACK,"*"+waterNum,200,70);

                drawWord(g,10,Color.BLACK,"第"+level+"关",30,140);//关卡数,积分
                drawWord(g,10,Color.BLACK,"目标"+goal,30,160);

                endTime=System.currentTimeMillis();
                long tim=30-(endTime-startTime)/1000;
                drawWord(g,20,Color.BLACK,"时间"+(tim>0?tim:0),50,100);
                break;

            case 2:
                g.drawImage(water,300,400,null);//药水组件
                drawWord(g,20,Color.BLACK,"价格"+price,150,250);
                drawWord(g,20,Color.BLACK,"买",150,275);
                if (shop){
                    count=count-price;
                    waterNum++;
                    shop=false;
                    GameWin.state=1;
                    startTime=System.currentTimeMillis();
                }
                break;

            case 3:
                drawWord(g,80,Color.BLACK,"失败",100,450);
                drawWord(g,60,Color.BLACK,"积分"+count,100,510);
                break;

            case 4:
                drawWord(g,80,Color.BLACK,"成功",100,450);
                drawWord(g,60,Color.BLACK,"积分"+count,100,510);
                break;

            default:

        }


    }

    boolean gameTime(){
        long tim=(endTime-startTime)/1000;
        if (tim>30){return true;}
        return false;
    }

    void reGame(){//重置元素
        level=1;//关卡
        goal=level*3;

        count=0;//分数

        waterNum=3;
        waterFlag=false;
    }

    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){//打印字符串
        g.setColor(color);
        g.setFont(new Font("宋体", Font.BOLD, size));
        g.drawString(str, x, y);
    }
}
