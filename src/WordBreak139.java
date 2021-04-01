import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {    //动态规划，先考察子串0~i
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i]) break;
                if (!dp[j]) continue;
                String suffix = s.substring(j, i);  //用j将字符串划分为前后两部分
                if (dp[j] && wordSet.contains(suffix)) {    //如果前子串能拆分并且后子串在字典里，则当前可解
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
