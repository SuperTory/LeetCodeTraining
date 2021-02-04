import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static int value = 123;

    public Test(){
        System.out.println(value);
    }

    public static int hammingDistance(int x, int y) {
        int count=0;
        while(x!=0&&y!=0){
            if(x%2!=y%2) count++;
            x/=2;
            y/=2;
        }
        return count;
    }

    public static void main(String[] args) {
        Test t=new Test();
        System.out.println(Test.value);
    }
}

