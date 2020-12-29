import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree15 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     *
     * 思路：先对数组进行排序，然后选定第一个数first
     * 再利用双指针法从之后的数组中同时左右移动两个指针寻找相加满足条件的结果
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            //注意重复的判断，排序之后，若当前的first和之前的数相同，则说明已经取过了，跳过
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int target = -nums[first];
            for (int second = first + 1, third = len - 1; second < third; ) {
                //取第二个数也要判断重复
                if (second>first+1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> tmpList = Arrays.asList(nums[first], nums[second], nums[third]);
                    res.add(tmpList);
                    second++;
                } else if (nums[second] + nums[third] > target) {
                    //若相加之和大于目标，说明第三个数太大了，向左移动third
                    third--;
                } else {
                    //若相加之和小于目标，向右移动second
                    second++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfThree15 sum=new SumOfThree15();
        int[] nums={0,0,0,0};
        List<List<Integer>> res=sum.threeSum(nums);
        for(List<Integer> sumlist:res){
            System.out.println(sumlist);
        }

    }
}
