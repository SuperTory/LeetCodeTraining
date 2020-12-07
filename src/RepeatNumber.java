import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatNumber {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length==0)
            return true;
        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                else{
                    int temp=numbers[numbers[i]];
                    numbers[numbers[i]]=numbers[i];
                    numbers[i]=temp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        List<Integer> list= Arrays.asList(12,2);
        int[] duplication = {100};
        boolean res = duplicate(numbers, 7, duplication);
        System.out.println(res);
        System.out.println(duplication[0]);

        System.out.println(numbers.getClass());
        System.out.println(list.getClass());
    }
}
