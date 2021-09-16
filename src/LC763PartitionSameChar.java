import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC763PartitionSameChar {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] str = S.toCharArray();
        for (int i = 0; i < str.length; i++)
            charMap.put(str[i], i);         //使用Map保存字符最后一次出现的下标

        List<Integer> res = new ArrayList<>();
        int end = 0, lastEnd = -1;
        for (int i = 0; i < str.length; i++) {
            int last = charMap.get(str[i]);
            end = Math.max(end, last);      //贪心法维护子串最远下标，使得相同字符包含在end内
            if (i == end) {
                res.add(i - lastEnd);
                lastEnd = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC763PartitionSameChar p = new LC763PartitionSameChar();
        String S = "ababcbacadefegdehijhklij";
        List<Integer> res = p.partitionLabels(S);
        for (int i : res)
            System.out.println(i);
    }
}
