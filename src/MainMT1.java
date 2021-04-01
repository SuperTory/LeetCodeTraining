import java.util.Scanner;

public class MainMT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        char[] target = sc.nextLine().toCharArray();

        int s = 0, t = 0, count = 0;
        while (t < target.length) {
            if (str[s] == target[t]) {
                s++;
                t++;
            } else {
                s++;
                count++;
            }
            s = s % 26;
        }

        System.out.println(count);
    }

}
