import java.util.ArrayList;
import java.util.List;

class Parent{
    public void greet(){
        System.out.println("P");
    }
}

class Son extends Parent{
    public void greet(){
        System.out.println("S");
    }
}
public class Title2 {


    public static void main(String[] args){
        List<Parent> list = new ArrayList<>();
        Parent p = new Son();
        p.greet();
    }
}
