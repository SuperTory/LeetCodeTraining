public class FlatBiTree114 {
    TreeNode last=null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);           //右，逆先序遍历
        flatten(root.left);            //左
        root.right = last;             //根的右指针指向上一个节点
        root.left = null;
        last = root;                    //用last指向上一个节点
    }

    public static void main(String[] args) {
        TreeNode tree=new TreeNode(new int[]{1,2,5,3,4,0,6});
        FlatBiTree114 f=new FlatBiTree114();
        f.flatten(tree);
        System.out.println();
    }
}
