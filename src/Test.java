import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Test {
    private int[] sum;

    public Test(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }

    public static void main(String[] args) {
        Test t = new Test(new int[]{-2, 0, 3, -5, 2, -1});
        int res = t.sumRange(2, 5);
        System.out.println(res);
    }
}
