import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache146 {
    static class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, ListNode> nodeMap;
    ListNode head, tail;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    private void move2tail(int key) {
        ListNode node = nodeMap.get(key);
        //将node节点从原位置取下
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //将node节点插入到队尾
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            move2tail(key);
            return nodeMap.get(key).value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            move2tail(key);
            nodeMap.get(key).value = value;
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(head.next.key);  //如果队列满了，从头部删除最久未用的键值
                //从链表中删除该节点
                head.next = head.next.next;
                head.next.pre = head;
            }
            //将新节点插入链表
            ListNode newNode = new ListNode(key, value);
            newNode.next = tail;
            newNode.pre = tail.pre;
            tail.pre.next = newNode;
            tail.pre = newNode;

            nodeMap.put(key, newNode);
        }
    }
}
