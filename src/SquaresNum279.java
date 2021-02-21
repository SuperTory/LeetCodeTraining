public class SquaresNum279 {
    public int numSquares1(int n) {   //暴力递归，超时
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) return 1;
        int min = 0x7fffffff;
        for (int i = sqrt; i > 0; i--) {
            int temp = numSquares(n - i * i) + 1;
            if (temp < min) min = temp;
        }
        return min;
    }

    public int numSquares(int n) {      //动态规划，将计算结果保存起来，避免递归的重复计算
        int[] nums = new int[n + 1];
        for (int i = 1; i <= Math.sqrt(n); i++) {
            nums[i * i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (nums[i] == 1) continue;
            int min = 0x7fffffff;
            for (int j = 1; j < i; j++) {
                int temp = nums[j] + nums[i - j];
                if (min > temp)
                    min = temp;
            }
            nums[i] = min;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        SquaresNum279 s = new SquaresNum279();
        int res = s.numSquares(1);
        System.out.println(res);
    }
}
