package Solution;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    //从小到大排序
    private static List<Integer> sSorted = new LinkedList<>();

    public static  void addElement(int e){
        int size = sSorted.size();
        if(size==0){
            sSorted.add(e);
            return;
        }
        int index =0;
        for(int i=size-1; i>=0; i--){
            if(sSorted.get(i) < e){
                index = i+1;
                break;
            }
        }
        sSorted.add(index, e);
        return;
    }

    public static void main(String[] args){
        addElement(3);
        addElement(2);
        addElement(5);
        addElement(1);
        addElement(7);

        System.out.println("list is:" + sSorted.toString());
    }
}
