import java.util.HashMap;
import java.util.Map;

public class LC560SumK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();   //用map<i, j>统计前缀和为i的出现了j次
        map.put(0, 1);   //初始化，前缀和为0的出现1次
        int prefixSum = 0, count = 0;

        for (int num : nums) {
            prefixSum += num;   //累加计算前缀和

            if (map.containsKey(prefixSum - k))     //两个前缀和作差为k，即我们要找的连续子串
                count += map.get(prefixSum - k);    //累积出现的次数

            if (map.containsKey(prefixSum))         //将当前prefixSum放入map
                map.put(prefixSum, map.get(prefixSum) + 1);
            else
                map.put(prefixSum, 1);
        }
        return count;
    }
}
