package Paixu;

public class SortUtils {
    //冒泡排序，从小到大
    public static  void BubbleSort(int[] numbers){
        int temp = 0;
        int size = numbers.length;
        for(int i=0; i<size; i++){
            for(int j=0; j< size-1-i; j++){
                if(numbers[j] > numbers[j+1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
    //快速排序，从小到大
    //因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)。
    public static void quick(int[] numbers){
        if(numbers.length >0){
            quickSort(numbers, 0, numbers.length-1);
        }
    }
    //快速排序中的分治算法
    public static void quickSort(int[] numbers, int low, int high){
        if(low <high){
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle-1);
            quickSort(numbers, middle+1, high);
        }
    }

    //
    public static int getMiddle(int[] numbers, int low, int high){
        int temp = numbers[low];
        int left = low;
        while (low < high){
            while (low< high && numbers[high] > temp){
                high--;
            }
            while (low< high && numbers[low] < temp){
                low++;
            }
            if(low<high){
                swap(numbers, low, high);
            }
        }
        swap(numbers, left, low);
        return low;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    //选择排序
    //挨个比较，每一躺都选出一个最小的
    public static void xuanzeSort(int[] numbers){
        int size = numbers.length;
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(numbers[j]<numbers[i])
                swap(numbers, i, j);
            }
        }
    }

    //插入排序
    //左边是有序的，右边是无序的，无序中的第一个插到左边
    public static  void charuSort(int[] numbers){
        int size = numbers.length;
        int j;
        for(int i=1; i<size; i++){
            if(numbers[i]<numbers[i-1]){
                int temp =numbers[i];
                for(j=i-1; j>=0 && numbers[j]>temp; j--){
                    numbers[j+1] =numbers[j];
                }
                numbers[j+1] = temp;
            }
        }
    }

    //堆排序
    public static void sort(int []arr){
        //1.构建大顶堆
        //从arr.length/2-1这个点开始调整堆，一直调整到i=0;

        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素

        //从最后一个元素开始，先交换，然后继续调整大根堆。
        //交换之后，从堆顶开始调节大根堆。
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
        // adjustHeap(arr,i,length)   第一个是数组，第二个是调整的节点位置，第三个是数组调整长度。
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    //注意调整堆，需要的是数组，以及开始比较的点，和结束比较的点，自然就把已经排好的给排除在外了。

    public static void adjustHeap(int [] data,int parentNode,int heapSize){
        int leftChild = 2*parentNode+1;// 左子树的下标
        int rightChild =2*parentNode+2;// 右子树的下标（如果存在的话）
        int largest = 0;
        //寻找3个节点中最大值节点的下标
        if(leftChild<heapSize && data[leftChild]>data[parentNode]){
            largest = leftChild;
        }else if(rightChild<heapSize && data[rightChild]>data[largest]){
            largest = rightChild;
        }else{
            largest = parentNode;
        }
        //如果最大值不是父节点，那么交换，并继续调整堆
        if(largest!=parentNode){
            swap(data,largest,parentNode);
            adjustHeap(data,largest,heapSize);
        }
    }

}
