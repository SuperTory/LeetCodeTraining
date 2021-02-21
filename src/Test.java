import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Test {
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int partition(int[] arr, int low, int high) {
        int flag = arr[low];     // 基准数据
        while (low < high) {
            // 从队尾向左移动找到小于flag的元素，并移动到low指针所在位置
            while (low < high && arr[high] >= flag) high--;
            arr[low] = arr[high];
            // 从队首向右查找大于flag的元素，移动到刚才high指针的那个位置
            while (low < high && arr[low] <= flag) low++;
            arr[high] = arr[low];
        }
        //左边小于flag，右边都大于flag，此时low指针的位置就是flag正确的位置
        arr[low] = flag;
        return low; // 返回划分的位置
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);    //找到划分的位置
            quickSort(arr, low, mid - 1);       //对前面的进行排序
            quickSort(arr, mid + 1, high);      //对后面的进行排序
        }
    }

    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<>();
        integers.add(1);
        integers.add(2);
        double d=Math.sqrt(15);
        double f = Math.ceil(d);
        System.out.println(d);
        System.out.println(f);
    }

}



