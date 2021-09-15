import java.util.Scanner;

public class TencentMain5 {
    static boolean bfs(int[] weights, int index, int temp, int m, int k, int len) {
        if (k == len) {
            return temp % m == 0;
        } else {
            if (index == weights.length)
                return false;
            return bfs(weights, index + 1, temp, m, k, len)
                    || bfs(weights, index + 1, temp + weights[index], m, k + 1, len);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] weights = new int[n];
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }

            int res = -1;
            for (int i = 1; i < weights.length; i++) {
                if (bfs(weights, 0, 0, m, 0, i)) {
                    res = i;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
