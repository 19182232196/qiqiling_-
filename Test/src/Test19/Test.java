package Test19;

public class Test {
    public static void main(String[] args) {
        new Thread(new Q(),"");
        for (int i=0;i<6;i++){
            System.out.println(Thread.currentThread().getName()+i);
            if (i==3){
                Thread.yield();
            }
        }
    }
}

class Q extends Thread implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 6; i++){
            System.out.println(Thread.currentThread().getName()+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i==3){
                Thread.yield();
            }
        }
    }
}