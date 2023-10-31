package Test17.pl;


import java.util.Random;

public class MAIN{

    public static boolean f1=false;
    public static boolean f2=false;

    public static void main(String[] args) {
        new Thread(new Rabbit()).start();
        new Thread(new Tortoise()).start();
        for(int q=0;q<1000;q++) {
            //让本线程睡一下
            try {
                Thread.sleep(0);//休息时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(f1&&f2) {
                if(Rabbit.d>Tortoise.c){
                    System.out.println("乌龟胜利");
                }
                else{
                    System.out.println("兔子胜利");
                }
                break;
            }
        }

    }
    public static class Rabbit implements Runnable {

        public static int d=0;
        private volatile int total=0;//记录行驶的步长
        @Override
        public  void run() {
            for(int i=1;i<=1000;i++){
                try {
                    Thread.sleep(12);//休息时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int step=new Random().nextInt(30);
                total+=step;
                if(total>=1000){
                    System.out.println("兔子结束");
                    d+=i;
                    break;
                }
            }
            System.out.println("兔子使用的时间="+d);
            f1=true;
        }
    }
    public static class Tortoise implements Runnable {
        public static int c=0;
        private volatile int sum=0;//记录行驶的步长
        @Override
        public void run() {
            for(int j=1;j<=100;j++){
                try {
                    Thread.sleep(0);//休息时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int m=new Random().nextInt(10);
                sum += m;
                if(sum >=100){
                    System.out.println("乌龟结束");
                    c+=j;
                    break;
                }
            }
            System.out.println("乌龟使用的时间="+c);
            f2=true;
        }
    }
}
