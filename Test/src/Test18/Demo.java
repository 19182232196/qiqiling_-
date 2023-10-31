package Test18;

public class Demo {
    public static void main(String[] args) {
        thread thread=new thread();

        thread.start();
    }
}
class thread extends Thread{
    public void run(){
        for (int i = 60; i > 0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
            System.out.println(i+"s");
        }
        super.run();
    }
}
