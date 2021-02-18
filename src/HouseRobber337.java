/*
二叉树的动态规划问题

首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
二叉树只有左右两个孩子，一个爷爷最多 2 个儿子，4 个孙子
根据以上条件，我们可以得出单个节点的钱该怎么算
4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构

 */
public class HouseRobber337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;

        //计算偷四个孙子的钱
        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        //比较偷4孙子和两个儿子哪个多
        return Math.max(money, rob(root.left) + rob(root.right));
    }


    /*
    解法二：
    使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
    任何一个节点能偷到的最大钱的状态可以定义为：
        当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        当前节点选择偷：当前节点能偷到的最大钱数 = 不偷左孩子 + 不偷右孩子 + 当前节点的钱数
     */
    public int rob2(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);    //先递归求解左右子节点状态
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  //不偷当前节点
        result[1] = left[0] + right[0] + root.val;  //偷当前节点

        return result;
    }

}
