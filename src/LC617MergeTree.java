public class LC617MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode newNode = new TreeNode();
        if (t1 == null) {
            newNode.val = t2.val;
            newNode.left = mergeTrees(null, t2.left);
            newNode.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            newNode.val = t1.val;
            newNode.left = mergeTrees(t1.left, null);
            newNode.right = mergeTrees(t1.right, null);
        } else {
            newNode.val = t1.val + t2.val;
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
        }

        return newNode;
    }

    public static void main(String[] args) {
        LC617MergeTree m = new LC617MergeTree();
        TreeNode t1 = new TreeNode(3);
        t1.left = null;
        t1.right = new TreeNode(7);
        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(7);

        TreeNode tres = m.mergeTrees(t1, t2);

        int[] numArr=new int[]{8,5,7,0,0,6,9};
        TreeNode t=new TreeNode(numArr);
        System.out.println(t.right.right.val);

    }
}
