import java.util.Map;

public class Title1 {
    public static  void greet(String word, StringBuffer sb){
        word = "Hey!";
        sb.append("123");
        System.out.println(word+":");
    }
    public static void main(String[] args){
        String word = "Hello";
        StringBuffer sb = new StringBuffer("abc");
        greet(word, sb);
        System.out.println("word is:"+word);
        System.out.println("sb is:"+ sb);
    }
}
