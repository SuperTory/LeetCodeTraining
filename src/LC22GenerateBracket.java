import java.util.ArrayList;
import java.util.List;

public class LC22GenerateBracket {
    List<String> bracketList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int stack = 0;
        generateString(n, stack, "");
        return bracketList;
    }

    public void generateString(int n, int stack, String s) {
        int tmpN = n;
        int tmpS = stack;
        if (n == 0) {
            while (tmpS > 0) {
                s = s.concat(")");
                tmpS--;
            }
            bracketList.add(s);
            return;
        }
        generateString(--tmpN, ++stack, s.concat("("));
        if (--stack > 0)
            generateString(n, --stack, s.concat(")"));
    }

    public static void main(String[] args) {
        LC22GenerateBracket g = new LC22GenerateBracket();
        List<String> res = g.generateParenthesis(3);
        System.out.println(res);
    }
}
