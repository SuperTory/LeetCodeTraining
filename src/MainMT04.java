import java.util.Scanner;

public class MainMT04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        if (m<=2){
            System.out.println(m);
            return;
        }

        int[] res=new int[n];
        res[0]=1;
        res[1]=2;
        int j = 1, i = 2, temp = 0;
        for (int k = 2; k < n; k++) {
            temp = a[i - 1][j - 1];
            j = i;
            i = temp;
            res[k-1]=i;
        }
        System.out.println(res[i%n-1]);
    }

}
