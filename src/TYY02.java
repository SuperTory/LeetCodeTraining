import java.util.Scanner;

public class TYY02 {
    final static int[] bucket = {100, 50, 20, 10, 5, 1};
    private static int res=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(0,n);
        System.out.println(res);
    }

    private static void dfs(int begin, int target){
        if (target==0){
            res++;
            return;
        }

        for (int i = begin; i < bucket.length; i++) {
            if (target- bucket[i]<0)
                continue;
            dfs(i,target-bucket[i]);
        }
    }
}
