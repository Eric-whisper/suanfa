import java.util.ArrayList;
import java.util.Stack;

public class Suanfaollection {
    //请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    // 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            String sti = str.toString();
            char[] strChar = sti.toCharArray();
            StringBuffer stb = new StringBuffer();
            for(int i=0;i<strChar.length;i++){
                if(strChar[i]==' '){
                    stb.append("%20");
                }else{
                    stb.append(strChar[i]);
                }
            }
            return stb.toString();
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
        }
    }

    //输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
    public ArrayList<Integer> printListFromTailToHead(ListNode listnode){
        Stack<Integer> stack = new Stack();
        while (listnode != null){
            stack.push(listnode.val);
            listnode = listnode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

    public class SolutionQueue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if(stack1.empty()&&stack2.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            if(stack2.empty()){
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    // 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变


    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k<=0) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        //p2向前移动k个节点
        for(int i=0;i<k-1;i++) {
            if(p2==null) return null;
            p2 = p2.next;
        }
        if(p2==null) return null;
        while(p2.next!=null) {
            p1=p1.next;
            p2=p2.next;
        }
        return p1;

    }

}