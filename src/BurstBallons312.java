import java.util.*;

public class BurstBallons312 {
    public int maxCoins(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int length = nums.length;

        //在数组前后边界添加元素1
        int[] nums2 = new int[length + 2];
        System.arraycopy(nums, 0, nums2, 1, length);
        nums2[0] = 1;
        nums2[length + 1] = 1;

        length += 2;
        int[][] dp = new int[length][length];     //动态规划状态表

        //开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
        //注意外层循环要倒着写，内层循环要正着写，因为要求dp[i][j] 需要知道dp[i+1][j-1]
        for (int i = length - 2; i > -1; i--) {
            for (int j = i + 2; j < length; j++) {
                //维护一个最大值；如果i、j相邻，值为0
                int max = 0;
                for (int k = i + 1; k < j; k++) {   //依次尝试用k划分开区间（i，j）
                    int temp = dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        BurstBallons312 b = new BurstBallons312();
        System.out.println(b.maxCoins(nums));
    }
}
