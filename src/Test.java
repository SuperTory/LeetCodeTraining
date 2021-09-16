import javafx.util.Pair;

import java.util.*;


public class Test {
    public int subarraySum(int[] nums, int k) {
        int left = 0, right = 1;
        int count = 0, sum = nums[0];
        while (left < nums.length) {
            if (sum == k) {
                count++;
                sum -= nums[left++];
            } else if (sum < k && right < nums.length) {
                sum += nums[right++];
            } else {
                sum -= nums[left++];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(6|5|16);
    }


}


