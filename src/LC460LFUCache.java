import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


class Node implements Comparable<Node> {
    int key;
    int value;
    int freq;   //节点使用次数
    int idx;    //访问先后顺序

    public Node() {
    }

    public Node(int key, int value, int idx) {
        this.key = key;
        this.value = value;
        freq = 1;
        this.idx = idx;
    }

    public int compareTo(Node node) {
        int diff = freq - node.freq;
        return diff != 0 ? diff : idx - node.idx;   //当freq相同时，比较访问先后
    }
}

class LFUCache {

    Map<Integer, Node> cache;   //使用map实现节点的快速查找
    Queue<Node> queue;          //使用小顶堆找到最小freq的节点
    int capacity;
    int size;
    int idx = 0;    //全局计数器为每个节点分配访问顺序

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        if (capacity > 0) {
            queue = new PriorityQueue<>(capacity);
        }
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;            //同时改变访问频率和访问顺序
        node.idx = idx++;
        queue.remove(node);     //重新插入小顶堆
        queue.offer(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {     //节点存在，则更新
            node.value = value;
            node.freq++;
            node.idx = idx++;
            queue.remove(node);
            queue.offer(node);
        } else {
            if (size == capacity) {     //达到容量，移除堆顶节点
                cache.remove(queue.peek().key);
                queue.poll();
                size--;
            }
            Node newNode = new Node(key, value, idx++);     //新增节点
            cache.put(key, newNode);
            queue.offer(newNode);
            size++;
        }
    }
}

