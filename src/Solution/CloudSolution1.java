package Solution;

public class CloudSolution1 {

    public static int getSum(int n){
        if(n<=1){
            return 0;
        }
        int sum = 0;
        boolean isTrue = false;
        for(int i=2; i<=n; i++){
            isTrue= false;
            for(int j=2; j<i-1; j++){
                if(i%j ==0){
                    isTrue = true;
                }
            }
            if(!isTrue){
                System.out.println(" " + i+ ",");
             sum += i;
            }
        }
        return sum;
    }

    public static void  main(String[] args){
        int sum = getSum(100);
        System.out.println("质数和是："+ sum);
    }
}
