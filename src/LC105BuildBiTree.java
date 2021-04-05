import java.util.Arrays;

public class LC105BuildBiTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == preorder[0])
                break;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int[] leftPre = Arrays.copyOfRange(preorder, 1, 1 + index);
        int[] rightPre = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        node.left = buildTree(leftPre, leftIn);
        node.right = buildTree(rightPre, rightIn);
        return node;
    }

    public static void main(String[] args) {
        LC105BuildBiTree b = new LC105BuildBiTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = b.buildTree(preorder, inorder);
        System.out.println();
    }
}
