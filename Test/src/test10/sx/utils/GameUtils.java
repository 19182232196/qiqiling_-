package test10.sx.utils;

import java.awt.*;

public class GameUtils {//图片种类
    public static Image upImg=Toolkit.getDefaultToolkit().getImage("img/up.png");//头
    public static Image downImg=Toolkit.getDefaultToolkit().getImage("img/down.png");
    public static Image leftImg=Toolkit.getDefaultToolkit().getImage("img/left.png");
    public static Image rightImg=Toolkit.getDefaultToolkit().getImage("img/right.png");

    public static Image bodyImg=Toolkit.getDefaultToolkit().getImage("img/body.png");//身

    public static Image foodImg=Toolkit.getDefaultToolkit().getImage("img/food.png");//食物

    public static void drawWord(Graphics g,String str,Color color,int size,int x,int y){//绘制文字
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}
