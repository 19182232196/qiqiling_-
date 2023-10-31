package Test18;

public class test {
	public static void main(String[] args) {
		A t1=new A();
		A t2=new A();

		t1.setPriority(10);
		t2.setPriority(1);

		t1.start();
		t2.start();
	}
}
class A extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.fillInStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+i);
		}
		super.run();
	}
}
