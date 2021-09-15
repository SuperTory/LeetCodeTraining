import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MT02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for (int i = 0; i < m; i++) {
            Integer n1=sc.nextInt();
            Integer n2=sc.nextInt();

            if (map.get(n1)==null){
                map.put(n1,new ArrayList<Integer>());
            }
            if (map.get(n2)==null){
                map.put(n2,new ArrayList<Integer>());
            }

            if (n1!=n2){
                if (!map.get(n1).contains(n2))
                    map.get(n1).add(n2);
                if (!map.get(n2).contains(n1))
                    map.get(n2).add(n1);
            }
        }

        HashMap<Integer,Integer> mm=new HashMap<>();
        for (int i = 0; i < n; i++) {
            mm.put(i,i);
        }

        for (int i = 0; i < q; i++) {
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            Integer nv1=mm.get(n1);
            Integer nv2=mm.get(n2);
            mm.put(n2,nv1);
            mm.put(n1,nv2);
        }

        int[] arr=new int[n+1];
        for (Integer integer:mm.keySet()){
            ArrayList<Integer> list=map.get(mm.get(integer));
            if (list==null){
                arr[integer]=0;
            }else
                arr[integer]=list.size();
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.print(arr[n - 1]);
    }

}