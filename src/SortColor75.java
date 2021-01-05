public class SortColor75 {
    public void sortColors(int[] nums) {
        int head=0,tail=nums.length-1;
        for(int i=0;i<=tail;i++){
            while(i<tail&&nums[i]==2)
                swap(tail--,i,nums);
            if(nums[i]==0)
                swap(head++,i,nums);

        }
    }

    void swap(int i,int j, int[] nums){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        SortColor75 s=new SortColor75();
        int[] nums=new int[]{2,0,1};
        s.sortColors(nums);
        System.out.println(nums);
    }
}
