import java.util.Deque;
import java.util.LinkedList;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LC84HistogramMaxArea {
    /*
    从左到右遍历每个柱子，若高度大于等于前一个则入栈，否则弹出栈顶比当前高度大的元素（高度比当前大，说明当前高度为右边界）
    然后依次以弹出的元素为高，和当前柱子i的距离为宽，计算面积
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];

        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            //依次弹出栈中比当前柱子低的元素
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                //跳过高度相同的柱子
                while (!stack.isEmpty() && height == heights[stack.peek()])
                    stack.pop();

                //计算两个柱子的距离
                int width;
                if (stack.isEmpty())
                    width = i;        //栈空，宽度为最左边到i
                else
                    width = i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        //若栈不为空，按相同方法弹出栈
        while(!stack.isEmpty()) {
            int height = heights[stack.pop()];
            while (!stack.isEmpty() && height == heights[stack.peek()])
                stack.pop();
            int width;
            if (stack.isEmpty())
                width = len;
            else
                width = len - stack.peek() - 1;

            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC84HistogramMaxArea h=new LC84HistogramMaxArea();
        int res=h.largestRectangleArea(new int[]{2,3});
        System.out.println(res);
    }
}
