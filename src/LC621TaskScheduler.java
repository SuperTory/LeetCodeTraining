import java.util.HashMap;
import java.util.Map;

public class LC621TaskScheduler {
    /*
    * 自己手动排序，但是有如下两个问题：
    *   ["A","A","A","B","B","B", "C","C","C", "D", "D", "E"] n=2
    *  每次从头取顺序为 ABCABCABCDE 空格 D，如果将D放到前面会省去空格
    * ["A","A","A","A","A","A","B","C","D","E","F","G"] n=2
    * 按顺序依次取出为ABCDEFGA 空格 空格  A。。。，可以将A穿插到前面
    *
    * */
    public int leastInterval1(char[] tasks, int n) {
        if (tasks.length < 1)
            return 0;

        Map<Character, Integer> taskMap = new HashMap<>();
        for (char c : tasks) {
            if (taskMap.containsKey(c)) {
                int count = taskMap.get(c);
                taskMap.put(c, ++count);
            } else {
                taskMap.put(c, 1);
            }
        }
        Map<Character, Integer> indexMap = new HashMap<>();
        for (char c : taskMap.keySet()) {
            indexMap.put(c, -99999);
        }
        int index = 1;
        while (true) {
            char c = 0;
            for (Map.Entry<Character, Integer> entry : taskMap.entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    c = entry.getKey();
                    int dis = index - indexMap.get(c);
                    if (dis > n) {
                        indexMap.put(c, index);
                        taskMap.put(c, --count);
                        break;
                    }
                }
            }
            if (c == 0) break;
            index++;
        }
        return index-1;
    }

    /**
     * 利用“桶思想”来解决，
     * 设计桶的大小为 n+1，则相同的任务恰好不能放入同一个桶，最密也只能放入相邻的桶。
     * 对于重复的任务，我们只能将每个都放入不同的桶中，因此桶的个数就是重复次数最多的任务的个数。
     * 一个桶不管是否放满，其占用的时间均为 n+1，这是因为后面桶里的任务需要等待冷却时间。
     * 最后一个桶是个特例，由于其后没有其他任务需等待，所以占用的时间为桶中的任务个数。
     * 最后一个桶中任务的个数就是出现次数最多的任务个数，如最多出现次数为6，共有3个任务出现了6次，那么最后一个桶为3
     *
     * 总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask=0;
        for(char c:tasks){  //找到出现次数最多的次数
            temp[c-'A']++;
            maxTask = Math.max(temp[c-'A'],maxTask);
        }
        for(int i=0;i<26;i++){  //统计有几个字母达到了最多的次数
            if(temp[i]==maxTask){
                countMaxTask++;
            }
        }
        return Math.max(tasks.length,(maxTask-1)*(n+1)+countMaxTask);
    }


    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        LC621TaskScheduler t = new LC621TaskScheduler();
        int res = t.leastInterval(tasks, 2);
        System.out.println(res);
    }
}
