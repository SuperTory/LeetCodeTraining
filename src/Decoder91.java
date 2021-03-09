public class Decoder91 {
    public int numDecodings(String s) {
        char[] arr=s.toCharArray();
        int[] dp=new int[arr.length];
        if(arr[0]=='0')
            return 0;
        if(arr.length<2)
            return 1;
        dp[0]=1;
        int value=(arr[0]-'0')*10+arr[1]-'0';
        if(arr[1]=='0')
            if(value>26){
                dp[0]=0;
                dp[1]=0;
            }
            else
                dp[1]=1;
        else{
            if(value>26){
                dp[1]=1;
            }
            else
                dp[1]=2;
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]!='0')
                dp[i]=dp[i-1];
            value=(arr[i-1]-'0')*10+arr[i]-'0';
            if(arr[i-1]!='0'&&value<27)
                dp[i]+=dp[i-2];
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        Decoder91 d=new Decoder91();
        System.out.println(d.numDecodings("26"));
    }
}
