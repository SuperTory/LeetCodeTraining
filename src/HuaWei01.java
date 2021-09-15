import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class HuaWei01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        int[] position = new int[s1.length];
        int[] work = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            position[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            work[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(position);
        Arrays.sort(work);

        int len = 0;
        for (int i = 0; i < position.length; i++) {
            int idx = search(work, position[i]);
            len = Math.max(len, minDis(position, work, i, idx));
        }
        System.out.println(len);
    }

    private static int search(int[] work, int i) {
        for (int j = 0; j < work.length; j++) {
            if (work[j] >= i) {
                return j - 1;
            }
        }
        return work.length - 1;
    }

    private static int minDis(int[] position, int[] work, int i, int idx) {
        int left = idx < 0 ? Integer.MAX_VALUE : (position[i] - work[idx]);
        int right = idx == work.length - 1 ? Integer.MAX_VALUE : (work[idx + 1] - position[i]);
        return Math.min(left, right);
    }
}
