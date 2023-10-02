package test9;

import java.awt.*;

public class Gold  extends Object {
     Gold(){
        this.x=(int) (Math.random()*450);
        this.y=(int) (Math.random()*500+250);
        this.width=52;
        this.height=52;
        this.flag=false;
        this.m=130;
        this.count=2;
        this.type=1;
        this.img= Toolkit.getDefaultToolkit().getImage("imgs/gold0.gif");
     }
}

class GoldMini extends Gold{
    GoldMini(){
        this.width=71;
        this.height=71;
        this.m=150;
        this.count=3;
        this.img= Toolkit.getDefaultToolkit().getImage("imgs/gold1.gif");
    }
}

class GoldPlus extends Gold{
    GoldPlus(){
        this.x=(int) (Math.random()*550);
        this.width=105;
        this.height=105;
        this.m=190;
        this.count=4;
        this.img= Toolkit.getDefaultToolkit().getImage("imgs/gold3.gif");
    }
}