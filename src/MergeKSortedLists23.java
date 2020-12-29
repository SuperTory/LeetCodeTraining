import java.util.List;
import java.util.Stack;

public class MergeKSortedLists23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Stack<Integer> stack=new Stack<>();
        for(int nullList=0;nullList<lists.length;){
            nullList=0;
            int minVal=10000,minList=0;
            for(int i=0;i<lists.length;i++){
                if(lists[i]==null)
                    nullList++;
                else{
                    if(lists[i].val<minVal){
                        minVal=lists[i].val;
                        minList=i;
                    }
                }
            }
            if (lists[minList]!=null) {
                stack.push(minVal);
                lists[minList] = lists[minList].next;
            }
            System.out.println();
        }

        ListNode headList=new ListNode();
        headList.next=null;
        while(!stack.empty()){
            ListNode newNode=new ListNode(stack.pop(),headList.next);
            headList.next=newNode;
        }
        return headList.next;
    }
    public static void main(String[] args) {
//        int[][] numArr={{1,4,5},{1,3,4},{2,6}};
        int[][] numArr={{1,2,3},{4,5,6,7}};
        ListNode[] lists=new ListNode[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            ListNode head=new ListNode();
            head.next=null;
            for (int j = numArr[i].length-1; j >=0; j--) {
                head.next= new ListNode(numArr[i][j],head.next);
            }
            lists[i]=head.next;
        }

        MergeKSortedLists23 m=new MergeKSortedLists23();
        m.mergeKLists(lists);
    }
}

