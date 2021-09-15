import java.util.LinkedList;
import java.util.Queue;

public class TencentMain1 {

    public TreeNode solve1(TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean flag = false;
            for (TreeNode node : queue) {
                if (node.left == null || node.right == null) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (TreeNode node : queue) {
                    node.left = null;
                    node.right = null;
                }
                break;
            } else {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public TreeNode solve(TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    if (node.left != null && node.right != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else {
                        node.right = null;
                        flag = false;
                    }
                } else {
                    node.left = null;
                    node.right = null;
                }

            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        TencentMain1 m = new TencentMain1();
        m.solve(root);
        System.out.println(root.val);
    }
}
