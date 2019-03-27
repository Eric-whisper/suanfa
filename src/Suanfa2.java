public class Suanfa2 {
    public static void main(String[] args){
        System.out.println("start");
        String str = " s";
        int count = getMost(str);
        System.out.println("最大字符串长度是:"+ count);
    }
    public static int getMost(String str){
        int size = str.length();
        System.out.println("size is:" + size);
        int count = 0;  //记录最大字符长度
        int curSize = 0;
        char cur;
        for(int i=0; i<size; i++){
            cur= str.charAt(i);
            if(cur != ' '){
                curSize++;
                if(curSize > count){
                    count = curSize;
                }
            }else{
                if(curSize > count){
                    count = curSize;
                }
                curSize = 0;
            }
        }
        return count;
    }
}
