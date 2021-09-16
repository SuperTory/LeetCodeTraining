public class LC198Burglary {
    public int rob(int[] nums) {
        int[] total=new int[nums.length];
        total[0]=nums[0];
        total[1]=Math.max(nums[0],nums[1]);
        total[2]=Math.max(nums[0]+nums[2],nums[1]);
        if(nums.length<=3)
            return total[nums.length-1];
        for(int i=3;i<nums.length;i++){
            total[i]=Math.max(total[i-1],total[i-2]+nums[i]);   //状态转移方程
        }
        return total[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,7,9,3,1};
        LC198Burglary b=new LC198Burglary();
        System.out.println(b.rob(nums));
    }
}
