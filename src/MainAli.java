import java.util.Scanner;

public class MainAli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        char[][] map = new char[n][m];
        String[] directions = new String[k];
        int si = 0, sj = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int index = s.indexOf('@');
            map[i] = s.toCharArray();
            if (index != -1) {
                si = i;
                sj = index;
                map[si][sj] = '.';
            }

        }
        for (int i = 0; i < k; i++) {
            directions[i] = sc.next();
        }

        int[] move = new int[2];
        for (String direc : directions) {
            switch (direc) {
                case "NORTH":
                    move = new int[]{-1, 0};
                    break;
                case "SOUTH":
                    move = new int[]{1, 0};
                    break;
                case "WEST":
                    move = new int[]{0, -1};
                    break;
                case "EAST":
                    move = new int[]{0, 1};
                    break;
            }
            while (si >= 0 && si < n && sj >= 0 && sj < m && map[si][sj] == '.') {
                si += move[0];
                sj += move[1];
            }
            si -= move[0];
            sj -= move[1];
        }
        System.out.printf("%d %d", si + 1, sj + 1);
    }
}
