import java.util.*;

public class GroupStr {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> strMap=new HashMap<>();
        for(String str:strs){
            char[] cArr=str.toCharArray();
            Arrays.sort(cArr);
            String key=String.valueOf(cArr);
            if(strMap.containsKey(key)){
                List<String> strList=strMap.get(key);
                strList.add(str);
            }else{
                List<String> strList=new ArrayList<>();
                strList.add(str);
                strMap.put(key,strList);
            }
        }

        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        String s="bat";
        char[] cArr=s.toCharArray();
        Arrays.sort(cArr);
        System.out.println(String.valueOf(cArr));
    }
}
