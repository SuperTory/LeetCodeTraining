/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 注意数组索引mid
 */
public class MidOfTwoList {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total=nums1.length+nums2.length;
        int mid=total/2;
        if(total%2==0){
            return (double)(findN(nums1,nums2,mid-1)+findN(nums1,nums2,mid))/2;
        }else
            return findN(nums1,nums2,mid);
    }

    public int findN(int[] nums1, int[] nums2, int n){//注意mid/n的下标位置
        int i=0,j=0;
        for(int m=0;m<=n;m++){
            if(nums1.length==0||i>=nums1.length)
                return nums2[j+n-m];
            if(nums2.length==0||j>=nums2.length)
                return nums1[i+n-m];
            if(nums2[j]<=nums1[i]){
                if(m==n)
                    return nums2[j];
                j++;
            }
            else{
                if(m==n)
                    return nums1[i];
                i++;
            }
        }
        return 500;
    }

    public static void main(String[] args) {
        MidOfTwoList midOfTwoList=new MidOfTwoList();
        int[] nums1={1,3};
        int[] nums2={2};
        double res=midOfTwoList.findMedianSortedArrays(nums1,nums2);
        System.out.println(res);

    }
}
