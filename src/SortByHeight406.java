import java.util.Arrays;
import java.util.Comparator;

public class SortByHeight406 {
    public static class HeightComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0])      //按数组第一个数h升序
                return 1;
            else if (o1[0] < o2[0])
                return -1;
            else
                return Integer.compare(o2[1], o1[1]);   //数组第二个数k降序
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        boolean[] flagArr = new boolean[people.length];
        int[][] resArr = new int[people.length][2];

        Arrays.sort(people, new HeightComparator());

        for (int[] heightArr : people) {
            int i, k;
            for (i = 0, k = 0; i < people.length; i++) {
                if (!flagArr[i]) {
                    if (k == heightArr[1]) break;
                    k++;
                }
            }
            flagArr[i] = true;
            resArr[i] = heightArr;
        }

        return resArr;
    }

    public static void main(String[] args) {
        SortByHeight406 s = new SortByHeight406();
        int[][] heightArr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] resArr = s.reconstructQueue(heightArr);
        System.out.println(resArr);
    }
}
