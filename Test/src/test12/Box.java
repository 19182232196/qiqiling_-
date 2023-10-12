package test12;

public class Box <T>{
    private T qwer;

    public T getQwer() {
        return qwer;
    }
    public void  setQwer(T qwer) {
        this.qwer = qwer;
    }

    public <Q> void qwe(Q q){
        System.out.println(q);
    }
}
