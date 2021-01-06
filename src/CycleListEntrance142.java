public class CycleListEntrance142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            //1、双指针差速移动，直到在环中相遇
            if (slow == fast) {
                slow = slow.next;
                //2、统计环中节点个数
                int ringNum = 1;
                while (slow != fast) {
                    slow = slow.next;
                    ringNum++;
                }
                //3、使两个指针相距ringNum同时从头移动，第一次相遇时就是入口
                slow = head;
                fast = head;
                while (ringNum > 0) {
                    fast = fast.next;
                    ringNum--;
                }
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        CycleListEntrance142 c = new CycleListEntrance142();
        c.detectCycle(l1);
    }
}
