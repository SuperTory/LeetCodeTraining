import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 由层序遍历数组形成二叉树
     *
     * @param numArr int数组，空指针用0表示
     */
    TreeNode(int[] numArr) {
        this.val = numArr[0];
        this.left = list2Tree(numArr, 1);
        this.right = list2Tree(numArr, 2);
    }

    private TreeNode list2Tree(int[] numArr, int index) {
        if (index >= numArr.length || numArr[index] == 0)
            return null;
        TreeNode newNode = new TreeNode(numArr[index]);
        newNode.left = list2Tree(numArr, 2 * index + 1);
        newNode.right = list2Tree(numArr, 2 * index + 2);
        return newNode;
    }

    private String serialize(TreeNode root) {
        if (root == null)
            return "null";
        else
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String treeStr){
        Queue<String> nodes=new LinkedList<>();
        for(String s:treeStr.split(","))
            nodes.offer(s);
        return string2Tree(nodes);
    }

    private TreeNode string2Tree(Queue<String> nodes){
        String s=nodes.poll();
        if (s.equals("null"))
            return null;
        TreeNode node=new TreeNode(Integer.parseInt(s));
        node.left=string2Tree(nodes);
        node.right=string2Tree(nodes);
        return node;
    }

    @Override
    public String toString() {
        return serialize(this);
    }
}