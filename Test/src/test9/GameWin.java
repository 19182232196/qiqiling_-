package test9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameWin extends JFrame {

    static int state;//游戏状态

    List<Object> objectList = new ArrayList<>();

    Bg bg =  new Bg();
    Line line= new  Line(this);

    {//添加金块
        boolean isPlace=true;
        for (int i = 0; i < 5; i++){
            double random = Math.random();
            Gold gold;
            if (random < 0.33){
                gold=new GoldMini();
            } else if (random < 0.66) {
                gold=new Gold();
            }else {
                gold=new GoldPlus();
            }

            for (Object obj:objectList){//解决堆叠
                if (gold.getRec().intersects(obj.getRec())){
                    isPlace=false;
                }
            }
            if (isPlace){
                objectList.add(gold);
            }else {
                isPlace=true;
                i--;
            }
        }
    }

    {//添加石块
        boolean isPlace=true;
        for (int i = 0; i < 3; i++){

            Rock rock=new Rock();//解决堆叠
            for (Object obj:objectList){
                if(rock.getRec().intersects(obj.getRec())){
                    isPlace=false;
                }
            }
            if (isPlace){
                objectList.add(rock);
            }else {
                isPlace=true;
                i--;
            }
        }
    }

    Image offScreenImage ;

    void launch(){
        this.setVisible(true);
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setTitle("学习--黄金矿工");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {//鼠标事件
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                switch (state){//判断游戏状态
                    case 0:
                        if (e.getButton()==3){
                            state=1;
                            bg.startTime=System.currentTimeMillis();
                        }
                        break;

                    case 1:
                        if (e.getButton()==1&&line.state==0){
                            line.state=1;
                        }
                        if (e.getButton()==3&&line.state==3&&Bg.waterNum>0){
                            Bg.waterFlag=true;
                            Bg.waterNum--;
                        }
                        break;

                    case 2:
                        if (e.getButton()==1){
                            bg.shop=true;
                        }
                        if (e.getButton()==3){
                            state=1;
                            bg.startTime=System.currentTimeMillis();
                        }
                        break;

                    case 3:

                    case 4:
                        if (e.getButton()==1){
                            state=0;
                            bg.reGame();
                            line.reGame();
                        }
                        break;

                    default:

                }
            }
        });

        while (true){
            repaint();

            nextLevel();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void nextLevel(){//下一关
        if (bg.gameTime()&&state==1){
            if (Bg.count>=bg.goal){
                if (Bg.level==5){
                    state=4;
                }else {
                    state=2;
                    Bg.level++;
                }
            }else {
                state=3;
            }
            dispose();
            GameWin gameWin1=new GameWin();
            gameWin1.launch();
        }
    }

    @Override
    public void paint(Graphics g){
        offScreenImage=this.createImage(500,700);
        Graphics gImage=offScreenImage.getGraphics();//双缓存解决闪动

        bg.paintSelf(gImage);

        if (state==1){
            for (Object obj:objectList){
                obj.paintSelf(gImage);
            }

            line.paintSelf(gImage);
        }

        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args){
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}
