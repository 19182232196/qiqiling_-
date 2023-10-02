package test9;

import java.awt.*;

public class Object {
    int x;
    int y;

    int width;
    int height;

    Image img;

    boolean flag=false;//标记是否移动

    int m;//质量

    int count;//积分

    int type;//证明物体

    void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
    }

    public int getWidth(){
        return width;//获取宽
    }

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);//获取矩形
    }
}
