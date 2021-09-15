import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW03 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int avg=in.nextInt();
        int n=in.nextInt();
        int[] score=new int[n*2];

        for (int i = 0; i < score.length; i++) {
            score[i]=in.nextInt();
        }

        Arrays.sort(score);
        int[] helper=new int[score.length];
        for (int i = 0; i < score.length; i++) {
            helper[i]=score[i]%avg;
        }
        int[][] res=new int[n][3];
        int j=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = helper.length-1; i >=0 ; --i) {
            int diff=(avg-helper[i])%avg;
            if (diff==avg){
                diff=0;
            }
            Integer idx=map.get(diff);
            if (idx==null){
                map.put(helper[i],i);
            }else {
                res[j++]=new int[]{score[idx],score[i],score[idx]+score[i]};
                map.remove(diff);
            }
        }

        if (j<n){
            System.out.println(0);
            return;
        }
        Arrays.sort(res,(a,b)->{
            if (a[2]==b[2]){
                return b[0]-a[0];
            }
            return b[2]-a[2];
        });
        for (int i = 0; i < n; i++) {
            System.out.print(res[i][0]+" ");
            System.out.print(res[i][1]+" ");
        }
    }
}
