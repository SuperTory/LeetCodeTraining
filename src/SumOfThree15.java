import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfThree15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int target = -nums[first];
            for (int second = first + 1, third = len - 1; second < third; ) {
                if (nums[second] + nums[third] == target) {
                    List<Integer> tmpList = Arrays.asList(nums[first], nums[second], nums[third]);
                    res.add(tmpList);
                } else if (nums[second] + nums[third] > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return res;
    }
}
