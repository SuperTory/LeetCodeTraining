import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTreeLevelTraverse102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();    //LinkedList模拟队列
        queue.offer(root);
        TreeNode tail = root;       //记录每层的尾节点
        while (queue.peek() != null) {
            TreeNode currentNode = queue.poll();
            levelList.add(currentNode.val);

            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);

            if (currentNode == tail) {
                resList.add(levelList);
                levelList = new ArrayList<>();
                if (queue.size() > 0)
                    tail = queue.getLast();     //遍历一层结束后，队列的最后一个节点就是尾节点
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        BTreeLevelTraverse102 b = new BTreeLevelTraverse102();
        List<List<Integer>> resList = b.levelOrder(root);
        System.out.println(resList.get(0).get(0));
    }
}
