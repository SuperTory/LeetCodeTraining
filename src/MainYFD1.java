import java.util.Scanner;

public class MainYFD1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        char[] res = new char[total];
        for (int i = 0; i < total; i++) {
            int len = scanner.nextInt();
            int[] nums = new int[len];
            for (int j = 0; j < len; j++) {
                nums[j] = scanner.nextInt();
            }

            int reverse = 1;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1])
                    reverse--;
            }
            if (reverse == 1) {
                res[i] = 'Y';
            } else if (reverse == 0 && nums[0] <= nums[nums.length - 1]) {
                res[i] = 'Y';
            } else
                res[i] = 'N';
        }
        for (char c : res)
            System.out.println(c);
    }
}
