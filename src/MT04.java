import java.util.Scanner;

public class MT04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        int q=sc.nextInt();

        for (;q>=0;q--){
            int u=sc.nextInt();
            int index=sc.nextInt();
            String subStr=str.substring(0,u);
            for (int i = 0; i < subStr.length(); i++) {
                boolean flag=true;
                for (int j = 0; j < i; j++) {

                }
            }
        }

    }
}
