import java.util.Stack;

public class LC236CommonAncestor {
    /**
     * 查找目标节点到根节点的路径
     *
     * @param root 根节点
     * @param t    目标节点
     * @param s    保存路径的栈
     * @return 是否找到目标节点
     */
    public boolean findPreNode(TreeNode root, TreeNode t, Stack<TreeNode> s) {
        if (root == null)
            return false;
        s.push(root);
        if (root == t || findPreNode(root.left, t, s) || findPreNode(root.right, t, s))
            return true;
        else {
            s.pop();
            return false;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        //查找根节点到p节点的路径
        findPreNode(root, p, stack);
        while (!stack.empty())
            stack1.push(stack.pop());   //倒栈，将路径节点顺序逆序
        //查找根节点到q节点的路径
        findPreNode(root, q, stack);
        while (!stack.empty())
            stack2.push(stack.pop());

        TreeNode common = stack1.peek();
        //依次将弹出两个路径栈，最后一个相同的节点就是最近公共祖先
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() == stack2.peek()) {
                common = stack1.pop();
                stack2.pop();
            } else
                return common;
        }
        if (stack1.empty() && stack2.empty())
            return null;
        else
            return common;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 6, 7});
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        LC236CommonAncestor c = new LC236CommonAncestor();
        TreeNode res = c.lowestCommonAncestor(root, p, q);

        System.out.println(res);
    }
}
