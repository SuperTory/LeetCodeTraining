import java.util.ArrayList;
import java.util.List;

public class LC131SubPalindrome {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> strList = new ArrayList<>();
        partition(s, strList);
        return res;
    }

    void partition(String s, List<String> strList) {
        if (s.length() == 0) {
            res.add(strList);
            return;
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int left, right;
            if (str[i] == str[i + 1]) {
                left = i;
                right = i + 1;
            } else
                left = right = i;
            while (left >= 0 && right <= str.length && str[left] == str[right]) {
                List<String> newList = new ArrayList<>(strList);
                newList.add(s.substring(left, right));
                partition(s.substring(right), newList);
                left--;
                right++;
            }
        }
    }

    public static void main(String[] args) {
        LC131SubPalindrome s = new LC131SubPalindrome();
        List<List<String>> res = s.partition("aab");
        System.out.println(res);
    }
}
