import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 利用HashMap来存放字符上一次出现的位置
 */
public class LongestUnrepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;
        if (s.equals(" "))
            return 1;
        int maxLen = 1;
        int tempLen = 1;
        Map<Character, Integer> charMap = new HashMap<>();

        int start = 0;
        int end = 0;
        for (; end < s.length(); end++) {
            char c = s.charAt(end);
            if (charMap.containsKey(c)) {    //字符c出现过
                int index = charMap.get(c);
                if (index >= start) {       //字符c出现在start与end中间
                    tempLen = end - start;      //注意下标计算距离
                    if (tempLen > maxLen)
                        maxLen = tempLen;
                    start = index+1;
                    end = start-1;
                    charMap.clear();
                }
            }else{
                tempLen = end - start + 1;      //注意计算距离
                charMap.put(c, end);
            }
        }

        if (tempLen > maxLen)
            maxLen = tempLen;
        return maxLen;
    }

    public static void main(String[] args) {
        LongestUnrepeat lu = new LongestUnrepeat();
        int res = lu.lengthOfLongestSubstring("pwwkew");

        System.out.println(res);
    }
}
