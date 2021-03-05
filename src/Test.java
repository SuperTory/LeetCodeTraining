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

    public static void main(String[] args) {
        int i = -17;
        int a = i >>> 4;
        System.out.println(Integer.MAX_VALUE);
    }

}

    public static void singleTheadPoolTest() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            pool.execute(() ->
                    out.println(Thread.currentThread().getName() + "=>" + ii)
            );
        }
    }



