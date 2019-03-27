package Yinyongleixing;

public class Test1 {

        private static int x=10;
        private static String  str= "123";
        private static StringBuffer strBuffer= new StringBuffer("abc");
        public static void updateValue(int value){
            value = 3 * value;
        }

        public static  void updateValue(String value){
            value = value+"sdfsa";
        }

        public static void updateValue(StringBuffer value){
            value = value.append("456");
        }
        public static void main(String[] args) {
            System.out.println("调用前x的值："+x);
            updateValue(x);
            updateValue(str);
            updateValue(strBuffer);
            System.out.println("调用后x的值："+x);
            System.out.println("str is"+str);
            System.out.println("strBuffer is"+strBuffer);
        }
}
