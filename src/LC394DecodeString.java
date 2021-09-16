import java.util.Stack;

public class LC394DecodeString {
    public String decodeString1(String s) {
        char[] cArr = s.toCharArray();
        Stack<String> st = new Stack<>();
        st.push(new String());
        for (int i = 0; i < cArr.length; i++) {
            if ('a' <= cArr[i] && cArr[i] <= 'z') {
                StringBuilder sb = new StringBuilder();
                sb.append(cArr[i]);
                while ('a' <= cArr[i + 1] && cArr[i + 1] <= 'z')
                    sb.append(cArr[++i]);
                st.push(sb.toString());
            } else if ('1' <= cArr[i] && cArr[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(cArr[i]);
                while ('1' <= cArr[i + 1] && cArr[i + 1] <= '9')
                    sb.append(cArr[++i]);
                st.push(sb.toString());
            } else if (cArr[i] == ']') {
                String topStr = st.pop();       //不应该使用一个栈来混合存放数字和字符串，容易混
                StringBuilder sb = new StringBuilder();
                sb.append(st.pop());
                sb.append(topStr);
                int num = Integer.valueOf(st.pop());
                StringBuilder ns = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    ns.append(sb);
                }
                st.push(ns.toString());
            }
        }
        if (!st.empty()) {
            String topStr = st.pop();
            StringBuilder sb = new StringBuilder();
            sb.append(st.pop());
            sb.append(topStr);
            return sb.toString();
        } else
            return st.pop();
    }

    public String decodeString(String str) {
        char[] s = str.toCharArray();
        StringBuilder res = new StringBuilder();
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        int num = 0;
        for (char c : s) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c >= 'a' && c <= 'z') {
                res.append(c);
            } else if (c == '[') { //将‘[’前的数字压入nums栈内， 字母字符串压入strs栈内
                nums.push(num);
                num = 0;
                strs.push(res.toString());
                res = new StringBuilder();
            } else {    //遇到‘]’时，操作与之相配的‘[’之间的字符，使用分配律
                int times = nums.pop();
                for (int j = 0; j < times; ++j)
                    strs.push(strs.pop() + res);

                res = new StringBuilder(strs.pop()); //之后若还是字母，就会直接加到res之后，因为它们是同一级的运算
                //若是左括号，res会被压入strs栈，作为上一层的运算
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        LC394DecodeString d = new LC394DecodeString();
        String res = d.decodeString(s);
        System.out.println(res);
    }
}
