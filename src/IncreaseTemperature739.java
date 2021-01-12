import java.util.Stack;

public class IncreaseTemperature739 {
    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
     * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        //使用栈来实现，栈中保存元素的下标
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                //递减栈，当新的元素小于栈顶元素时，弹出，此时的下标距离就是还需等待的天数
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        IncreaseTemperature739 i = new IncreaseTemperature739();
        int[] res = i.dailyTemperatures(temperatures);
    }
}
