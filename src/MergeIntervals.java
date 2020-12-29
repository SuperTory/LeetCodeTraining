import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {4,5},{0,1}};
        MergeIntervals m = new MergeIntervals();
        m.quickSort(intervals,0,intervals.length-1);

        List<int[]> intList=new ArrayList<>();
        int[] tmpInterval=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=tmpInterval[1]){
                if(intervals[i][1]>tmpInterval[1])
                    tmpInterval[1]=intervals[i][1];
            }else{
                intList.add(tmpInterval);
                tmpInterval=intervals[i];
            }
        }
        intList.add(tmpInterval);




        int[][] mergedArr=new int[intList.size()][];
        for (int i = 0; i < intList.size(); i++) {
            mergedArr[i]=intList.get(i);
        }

        System.out.println(mergedArr[0][0]);

    }

    public void quickSort(int[][] arrays, int start, int end) {
        if (start < end) {
            int mid = partition(arrays, start, end);
            quickSort(arrays, start, mid - 1);
            quickSort(arrays, mid + 1, end);
        }
    }

    /**
     * 划分数组
     *
     * @param arrays 数组
     * @param start  起始坐标
     * @param end    结束坐标
     * @return 划分点下标
     */
    private int partition(int[][] arrays, int start, int end) {
        int flag_data = arrays[end][0];     //选取最后一个元素作为轴
        int index = start;

        for (int i = start; i < end; i++) {
            if (arrays[i][0] < flag_data) {
                swap(arrays, i, index);
                index++;
            }
        }
        swap(arrays, index, end);
        return index;
    }

    private static void swap(int[][] arr, int a, int b) {
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
