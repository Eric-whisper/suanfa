package Paixu;


import java.util.Arrays;

//快速排序
public class Kuaipai {

    public static void main(String[] args){
        int[] a = {10,20,3,4,1,2,10,7,30,14,9,1,59};
        quick(a);
        System.out.println(Arrays.toString(a));
    }
    public static void quick(int[] numbers){
        if(numbers.length >0){
            quickSort(numbers, 0, numbers.length-1);
            System.out.println("kuaipai");
        }
    }
    //快速排序中的分治算法
    private static void quickSort(int[] numbers, int low, int high){
        if(low <high){
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle-1);
            quickSort(numbers, middle+1, high);
        }
    }

    //
    private static int getMiddle(int[] numbers, int low, int high){
        int temp = numbers[low];
        int left = low;
        while (low < high){
            while (low< high && numbers[high] >= temp){
                high--;
            }
            if(low<high){
                numbers[low] = numbers[high];
            }
            while (low< high && numbers[low] <= temp){
                low++;
            }
            if(low<high){
                numbers[high] = numbers[low];
            }
        }
        numbers[low] = temp;
        return low;
    }

    private static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        System.out.println("swap");
    }
}
