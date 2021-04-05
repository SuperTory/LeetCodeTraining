/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 来源：力扣（LeetCode）34
 *
 * 使用二分查找法将时间复杂度控制在O（logN）
 */
public class LC34FindFirstLast {
    public int[] searchRange(int[] nums, int target) {
        return findTarget(nums,0, nums.length-1, target);
    }

    private int[] findTarget(int[] nums,int low,int high,int target){
        if(low>high)
            return new int[]{-1,-1};
        int mid=(low+high)/2;
        if(nums[mid]==target){
            int left=mid,right=mid;
            while(left-1>=0&&nums[left-1]==target)
                left--;
            while(right+1<nums.length&&nums[right+1]==target)
                right++;
            return new int[]{left,right};
        }else if(nums[mid]>target){
            return findTarget(nums,low,mid-1,target);
        }else
            return findTarget(nums,mid+1,high,target);
    }

    public static void main(String[] args) {
        LC34FindFirstLast findFirstLast34 =new LC34FindFirstLast();
        int[] nums = {5,7,7,8,8,10};
        int[] res= findFirstLast34.searchRange(nums,6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
