public class LongestPalindromicSubstring {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 利用动态规划法，一个字符串为回文串 = 其左右两端的字符相等 + 其中间的子串也是回文串
     *
     * @param s 输入一个字符串 s
     * @return s 中最长的回文子串
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        //动态规划的核心在于状态转移，而状态转移的表示就是二维表格，用dp[][]记录二维表格中的状态
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;

        int maxLen = 1;
        int start = 0;
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j])   //左右两端不相等，不是回文串
                    dp[i][j] = false;
                else {                              //字符串长度小于2且左右两端相等定为回文串，如a，bb
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];    //左右两端相等且长度大于2，和子串状态有关
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
