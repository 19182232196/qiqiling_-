package test9;

import java.awt.*;

public class Line {
    int x=380;
    int y=180;

    int endx=500;
    int endy=500;

    double length=50;


    double MIN_length=50;
    double MAX_length=500;
    double n=0;

    int dir=1;

    int state;//0 摇摆 1 抓取 2 返回 3 抓取返回

    Image hook=Toolkit.getDefaultToolkit().getImage("imgs/hook.png");

    GameWin frame;

    Line(GameWin frame){this.frame=frame;}



    void logic(){//碰撞检测
        for (Object obj:this.frame.objectList){
            if (endx>obj.x&&endx<obj.x+obj.width &&endy>obj.y&&endy<obj.y+obj.height){
                state=3;
                obj.flag=true;
            }
        }
    }

    void lines(Graphics g){//绘制
        endx=(int) (x+length*Math.cos(n*Math.PI));
        endy=(int) (y+length*Math.sin(n*Math.PI));
        g.setColor(Color.red);
        g.drawLine(x-1,y,endx-1,endy);
        g.drawLine(x,y,endx,endy);
        g.drawLine(x+1,y,endx+1,endy);
        g.drawImage(hook,endx-36,endy+2,null);
    }

    void paintSelf(Graphics g){
        logic();
        switch (state){
            case 0:
                if(n<0.1){dir=1;}
                else if (n>0.9){dir=-1;}
                n=n+0.005*dir;
                lines(g);
                break;

            case 1:
                if (length<MAX_length){
                    length=length+10;
                    lines(g);
                }else {
                    state=2;
                }
                break;

            case 2:
                if (length>MIN_length){
                    length=length-10;
                    lines(g);
                }else {
                    state=0;
                }
                break;

            case 3:
                int m=1;
                if (length>MIN_length){
                    length=length-10;
                    lines(g);
                    for (Object obj:this.frame.objectList){
                        if (obj.flag){
                            m=obj.m;
                            obj.x=endx-obj.getWidth()/2;
                            obj.y=endy;
                            if (length<=MIN_length){
                                obj.x=-150;
                                obj.y=-150;
                                obj.flag=false;

                                Bg.waterFlag=false;

                                Bg.count+=obj.count;//加分

                                state=0;
                            }
                            if (Bg.waterFlag){
                                if (obj.type==1){
                                    m=1;
                                }
                                if (obj.type==2){
                                    obj.x=-150;
                                    obj.y=-150;
                                    obj.flag=false;
                                    Bg.waterFlag=false;
                                    state=2;
                                }
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
        }
    }
    void reGame(){//重置元素
        n=0;
        length=MIN_length;
    }
}
