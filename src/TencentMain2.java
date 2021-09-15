import java.util.Scanner;
import java.util.Stack;

public class TencentMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        char[] arr = str.toCharArray();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = arr[i] - '0';

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && (nums[i] + stack.peek() == 10))
                stack.pop();
            else
                stack.push(nums[i]);
        }

        System.out.println(stack.size());
    }
}
