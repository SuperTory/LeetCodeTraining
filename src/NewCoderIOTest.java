import java.util.Scanner;

public class NewCoderIOTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int left = 0;
        int i = L;
        for (; i < 101; i++) {
            int j = N / i;
            if (i % 2 == 0) {
                if ((j + 0.5) * i == N) {
                    left = i / 2 - 1;
                    break;
                }
            } else {
                if (j * i == N) {
                    left = i / 2;
                    break;
                }
            }
        }
        if (i >=100) {
            System.out.println("No");
        } else {
            int start = N / i - left;
            System.out.printf("%d", start);
            for (int j = 1; j < i; j++) {
                System.out.printf(" %d", ++start);
            }
        }
    }
}
