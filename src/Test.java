import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Test {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        subset(nums, 0, numList, visited);
        return res;
    }

    void subset(int[] nums, int index, List<Integer> numList, boolean[] visited) {
        if (index == nums.length) {
            res.add(new ArrayList<>(numList));
            return;
        }

        subset(nums, index + 1, numList, visited);
        if (index > 0 && nums[index] == nums[index - 1] && !visited[index - 1])
            return;
        numList.add(nums[index]);
        visited[index] = true;
        subset(nums, index + 1, numList, visited);
        numList.remove(numList.size() - 1);
        visited[index] = false;

    }

    public static void main(String[] args) {
        Test t = new Test();
        List<List<Integer>> res = t.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(res);
    }
}
