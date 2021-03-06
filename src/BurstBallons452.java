import java.util.Arrays;
import java.util.Comparator;

public class BurstBallons452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int end = points[0][1];
        int count = 1;
        for (int[] o : points) {
            if (o[0] > end) {
                count++;
                end = o[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        BurstBallons452 b = new BurstBallons452();
        int res = b.findMinArrowShots(points);
        System.out.println(res);
    }
}
