import java.util.ArrayList;
import java.util.List;

public class LC93RestoreIPAddresses {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder subStr = new StringBuilder();
        subIpStr(s.toCharArray(), "", 0, 0);
        return res;
    }

    private void subIp(char[] s, StringBuilder subStr, int index, int k) {
        if (k == 4 || index == s.length) {  //达到四个或者字符串到头都会终止
            if (k == 4 && index == s.length)    //只有恰好满足两者才能作为结果
                res.add(subStr.substring(0, subStr.length() - 1));
        } else {
            if (s[index] == '0') {  //子串开头为0只能有一种情况
                subIp(s, subStr.append("0."), index + 1, k + 1);
                subStr.delete(subStr.length() - 2, subStr.length());
            } else {
                int temp = 0;       //否则可以累计向后添加子串
                for (int i = 0; i < 3 && (index + i < s.length); i++) {
                    temp = temp * 10 + (s[index + i] - '0');
                    if (temp <= 255) {
                        subStr.append(temp);
                        subStr.append('.');
                        subIp(s, subStr, index + i + 1, k + 1);
                        //递归结束后要进行回溯，删除添加的字符
                        subStr.delete(subStr.length() - 2 - i, subStr.length());
                    }
                }
            }
        }
    }

    private void subIpStr(char[] s, String subStr, int index, int k) {
        if (k == 4 || index == s.length) {
            if (k == 4 && index == s.length)
                res.add(subStr.substring(0, subStr.length() - 1));
        } else {
            if (s[index] == '0') {
                subIpStr(s, subStr + "0.", index + 1, k + 1);
            } else {
                int temp = 0;
                for (int i = 0; i < 3 && (index + i < s.length); i++) {
                    temp = temp * 10 + (s[index + i] - '0');
                    if (temp <= 255) {
                        subIpStr(s, subStr + temp + ".", index + i + 1, k + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LC93RestoreIPAddresses r = new LC93RestoreIPAddresses();
        List<String> res = r.restoreIpAddresses("101023");
        System.out.println(res);
    }
}
