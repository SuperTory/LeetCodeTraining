import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++)
            nums[i] = scanner.nextInt();
        int target = scanner.nextInt();

        int count = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                int temp = nums[i];
                for (int k = i + 1; k < j; k++) {
                    temp = temp | nums[k];
                }
                if (temp <= target)
                    count++;
            }
        }

        count = count % 1000000007;
        System.out.println(count);
    }
}
