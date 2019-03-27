package Duoxiancheng;

public class Duoxiancheng2 implements Runnable{
    @Override
    public void run() {
        System.out.println("线程2");
    }

    public static void main(String[] args){
        Thread thread = new Thread(new Duoxiancheng2());
        thread.start();

    }
}
