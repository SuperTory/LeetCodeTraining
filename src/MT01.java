import java.util.*;

public class MT01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int len = 1; i + len < s.length(); len++) {
                int num = Integer.parseInt(s.substring(i, i + len));
                if (num % 22 == 0)
                    res++;
            }
        }
        System.out.println(res);
    }
}