/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */

class SumOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumNode(l1, l2, 0);
    }

    public ListNode sumNode(ListNode l1, ListNode l2, int up) {
        if (l1 == null && l2 == null && up == 0) {  //全部为空，且无进位
            return null;
        }
        if (l1 == null && l2 == null) {  //全为空但有新的进位
            return new ListNode(up);
        }
        if (l1 != null && l2 != null) { //全不为空
            return new ListNode((l1.val + l2.val + up) % 10,
                    sumNode(l1.next, l2.next, (l1.val + l2.val + up) / 10));
        }
        if (l1 == null) { //l1为空
            return new ListNode((l2.val + up) % 10,
                    sumNode(null, l2.next, (l2.val + up) / 10));
        }   //l2为空
        return new ListNode((l1.val + up) % 10,
                sumNode(null, l1.next, (l1.val + up) / 10));

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }
}