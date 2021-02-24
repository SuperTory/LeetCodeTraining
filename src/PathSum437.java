import java.util.ArrayList;
import java.util.List;

public class PathSum437 {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        List<Integer> sumList = new ArrayList<>();
        pathSum(root, sum, sumList);
        return count;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> sumList) {
        if (root == null) return;
        sumList.add(0);     //每遍历一个节点都在数组增加一个和
        for (int i = 0; i < sumList.size(); i++) {
            int total = sumList.get(i);
            total += root.val;      //将当前节点的值累加到之前的每个和上，看是否达到总和
            sumList.set(i, total);
            if (total == sum)
                count++;
        }
        List<Integer> newList = new ArrayList<>(sumList);
        pathSum(root.left, sum, sumList);
        pathSum(root.right, sum, newList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new int[]{5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1});
        PathSum437 p = new PathSum437();
        int res = p.pathSum(root, 22);
        System.out.println(res);
    }
}
