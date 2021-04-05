import java.util.*;

public class LC40ArraySum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);    // 对元素排序，使相同元素放在一起

        Deque<Integer> path = new ArrayDeque<>(candidates.length);
        dfs(candidates, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     距离目标的差值
     * @param path       从根结点到叶子结点的路径
     * @param res        结果列表
     */
    private void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 大剪枝：当前值大于目标值肯定凑不成，不必展开
            if (target - candidates[i] < 0)
                break;

            // 小剪枝：排序之后相同元素会放在一起，避免展开相同元素的节点，
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;

            path.addLast(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        LC40ArraySum solution = new LC40ArraySum();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
}
