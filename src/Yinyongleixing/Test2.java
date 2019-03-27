package Yinyongleixing;

import java.util.Arrays;

public class Test2 {
    public  static  int[] a= {1,2,3,4,5};

    public static  void swap(int[] a, int i, int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static  void main(String[] args){
        swap(a, 2, 3);
        System.out.println("value is:" + Arrays.toString(a));
    }
}
