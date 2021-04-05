import java.util.*;

public class LC322CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        Set<Integer> amountSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();  //利用队列实现广度优先遍历
        queue.offer(amount);
        int step = 0;
        while (queue.peek() != null) {
            int len = queue.size();     //记录每层的长度，每走完一层步数+1
            for (int p = 0; p < len; p++) {
                int tmp = queue.poll();
                if (tmp == 0)
                    return step;
                for (int i = coins.length - 1; i >= 0; i--) {
                    //利用Set记录遍历过的值来进行剪枝，防止运行超时
                    if (coins[i] <= tmp && !amountSet.contains(tmp - coins[i])) {
                        queue.offer(tmp - coins[i]);
                        amountSet.add(tmp - coins[i]);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
//        CoinChange322 c = new CoinChange322();
//        int res = c.coinChange(new int[]{1, 2, 5}, 11);
//        System.out.println(res);

        int[] arr=new int[]{1, 2, 5};
        List<Integer> arrList=Arrays.asList(4,2,7);
        Collections.sort(arrList);
        System.out.println(arrList.get(0));
    }
}
