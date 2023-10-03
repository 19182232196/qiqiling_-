package test10.sx.obj;

import test10.sx.GameWin;

import java.awt.*;

public class GameObj {
    Image img;//图片
    int x;//坐标
    int y;
    int width=30;//宽高
    int height=30;
    GameWin frame;//窗口类

    public void setImg(Image img) {
        this.img = img;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    public GameObj() {

    }
    public GameObj(Image img, int x, int y, int width, int height, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.frame = frame;
    }

    public void paintSelf(Graphics g){//绘制自身
        g.drawImage(img,x,y,width,height,null);
    }

    public GameObj(Image img, int x, int y, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.frame = frame;
    }
}
