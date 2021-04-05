import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC128LongestConsequence {
    public int longestConsecutive1(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            if (!numMap.containsKey(i)) {
                numMap.put(i, 1);
                numSet.add(i);
            }
        }
        int max = 0;
        for (int key : numMap.keySet()) {
            int value = numMap.get(key);
            int tempKey = key - 1;
            while (numSet.contains(tempKey)) {
                value += numMap.get(tempKey);
                numSet.remove(tempKey);
                tempKey--;
            }
            numMap.put(key, value);
            max = Math.max(max, value);
        }
        return max;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {   //如果set中包含num-1，则跳过本num
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {  //直到找到最小的num后再开始递增遍历
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LC128LongestConsequence l = new LC128LongestConsequence();
        int res = l.longestConsecutive(nums);
        System.out.println(res);
    }
}
