import java.util.*;

public class TopKFrequent347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numMap=new HashMap<>();

        for(int num:nums){
            if (numMap.containsKey(num)) {
                int count = numMap.get(num);
                numMap.put(num,++count);
            }else {
                numMap.put(num,1);

            }
        }

        Set<Map.Entry<Integer,Integer>> entrySet=numMap.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(entrySet);

        //定义比较Entry的内部类
        class IntegerComparator implements Comparator<Map.Entry<Integer, Integer>> {
            public int compare(Map.Entry o1, Map.Entry o2) {
                int num1=(int)o1.getValue();
                int num2=(int)o2.getValue();
                return Integer.compare(num1, num2);
            }
        }

        mapList.sort(new IntegerComparator());

        int[] resArr=new int[k];
        for (int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry=mapList.get(mapList.size()-i-1);
            resArr[i]=entry.getKey();
        }

        return resArr;
    }

    public static void main(String[] args) {
        TopKFrequent347 t=new TopKFrequent347();
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] res=t.topKFrequent(nums,2);
        for(int i:res){
            System.out.println(i);
        }
    }
}
