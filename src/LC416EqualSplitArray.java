import java.util.Arrays;

public class LC416EqualSplitArray {
    int target = 0;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum / 2 * 2 != sum)
            return false;
        target = sum / 2;
        Arrays.sort(nums);
        return sumUp(nums,0,0);
    }

    private boolean sumUp(int[]nums,int index,int sum){
        if(sum>target||index>nums.length-1)
            return false;
        if(sum==target)
            return true;
        return sumUp(nums,index+1,sum+nums[index])||sumUp(nums,index+1,sum);
    }

    public static void main(String[] args) {
        LC416EqualSplitArray e=new LC416EqualSplitArray();
        boolean res=e.canPartition(new int[]{1,5,11,5});
        System.out.println(res);
    }
}
