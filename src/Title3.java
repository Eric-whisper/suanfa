public class Title3 {
    //由一道题目说开去：编写一段代码，打印出一个二维布尔数组的内容。其中*表示真，空格表示假。打印出行号和列号。
    public class Ex_11 {

        public  void printBooleans(boolean[][] a){
            int rowNum = a.length;
            int colNum=0;
            if(rowNum>0)
                colNum = a[0].length;
            for(int i=0;i<rowNum;i++){
                for(int j=0;j<colNum;j++){
                    if(a[i][j])System.out.print("["+i+"]["+j+"]"+"*");
                    else System.out.print("["+i+"]["+j+"]"+" ");
                }
                System.out.println();
            }
        }

        public  void main(String[] args) {
            // TODO Auto-generated method stub
            boolean[][] b = {{true,true,false,false},{false,false,true,true}};
            boolean[][] c={};
            printBooleans(b);
            printBooleans(c);
        }

    }
}
