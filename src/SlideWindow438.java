import java.util.ArrayList;
import java.util.List;

public class SlideWindow438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] str = s.toCharArray();
        char[] pChar = new char[26];
        for (char c : p.toCharArray())
            pChar[c - 'a']++;

        int left = 0, right = -1;
        List<Integer> res = new ArrayList<>();
        while (left < s.length() - p.length() + 1) {
            if (right - left < p.length() - 1)  //如果窗口长度小于目标，滑动窗口右边界
                right++;
            else {                              //否则对窗口内的子串进行判断
                char[] subChar = new char[26];
                for (int i = left; i <= right; i++)     //统计并比较子串内字符出现次数
                    subChar[str[i] - 'a']++;
                boolean flag = true;
                for (int i = 0; i < 26; i++)
                    if (subChar[i] != pChar[i]) {
                        flag = false;
                        break;
                    }
                if (flag)
                    res.add(left);
                left++;                        //判断完后滑动窗口左边界
            }
        }
        return res;
    }
}
