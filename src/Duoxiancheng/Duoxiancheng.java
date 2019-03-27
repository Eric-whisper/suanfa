package Duoxiancheng;

public class Duoxiancheng extends Thread{
    public Duoxiancheng(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("输出。。。");
    }

    public static void main(String[] args){
        Duoxiancheng demo1 = new Duoxiancheng("first");
        Duoxiancheng demo2 = new Duoxiancheng("second");
        demo1.start();
        demo2.start();
        System.out.println("主线程！！！");
    }
}
