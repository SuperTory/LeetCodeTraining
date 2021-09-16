import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 采用回溯法遍历每一种可能性，若符合则添加到结果列表中
 */
public class LC39ListToSum {
    private List<List<Integer>> resList = new ArrayList();
    private int[] sortedArr;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        sortedArr = candidates;
        List<Integer> candList = new ArrayList<>();
        subtract(candList, target);
        return resList;
    }

    private void subtract(List<Integer> candList, int tempTarget) {
        if (tempTarget == 0) {
            resList.add(candList);
            return;
        }
        for (int j : sortedArr) {
            if (!candList.isEmpty()&&j<candList.get(candList.size() - 1))
                continue;
            if (j > tempTarget)
                break;
            //注意这里使用深拷贝，防止对原candList的修改
            List<Integer> tempList = new ArrayList<>(candList);

            tempList.add(j);
            subtract(tempList, tempTarget - j);
        }
    }

    public static void main(String[] args) {
        LC39ListToSum l = new LC39ListToSum();
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> res=l.combinationSum(candidates, 7);
        System.out.println();
    }
}
