public class Suanfa3 {
    public static void main(String[] args){
        System.out.println("start");
        String str = "s";
        int count = getMostLength(str);
        System.out.println("最大字符串长度是:"+ count);
    }

    public static int getMostLength(String str){
        int size = str.length();
        int count = 0;  //记录最大字符长度
        int curSize = 0;
        int spaceIndex = -1;  //记录当前空格的位置，第一个空格的位置默认为第一个字符之前-1
        char cur;
        for(int i=0; i<size; i++){
            cur =str.charAt(i);
            if(cur == ' '){
                curSize = i-spaceIndex-1;
                spaceIndex = i;
                if(curSize >count){
                    count = curSize;
                }
            }
        }
        curSize = size-spaceIndex-1;
        if(curSize >count){
            count = curSize;
        }
        return count;
    }
}
