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
     * @param numArr int数组，空指针用0表示
     */
    TreeNode(int[] numArr){
        this.val=numArr[0];
        this.left=list2Tree(numArr,1);
        this.right=list2Tree(numArr,2);
    }

    private TreeNode list2Tree(int[] numArr,int index){
        if (index>=numArr.length||numArr[index]==0)
            return null;
        TreeNode newNode=new TreeNode(numArr[index]);
        newNode.left=list2Tree(numArr,2*index+1);
        newNode.right=list2Tree(numArr,2*index+2);
        return newNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}