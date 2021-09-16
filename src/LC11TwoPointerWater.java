public class LC11TwoPointerWater {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * @param height 指针高度数组
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        int num = height.length;
        int max = 0;
        for (int i = 0, j = num - 1; i < j; ) {
            int tempArea;
            if (height[i] < height[j]) {    //双指针法，每次移动两边中较小的一条边
                tempArea = height[i] * (j - i);
                i++;
            } else {
                tempArea = height[j] * (j - i);
                j--;
            }
            if (tempArea > max)
                max = tempArea;
        }
        return max;
    }
}
