import java.util.*;

import static java.util.Arrays.binarySearch;

public class Main {
    static class Station implements Comparable<Station>{
        String name;
        int start;
        int end;

        public Station(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Station o) {
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Station> stationList=new ArrayList<>();
        while(sc.hasNextLine()) {
            String s=sc.nextLine();
            if (s.equals("")){
                break;
            }
            String[] data = s.split(",");
            Station station=new Station(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            stationList.add(station);
        }
        Collections.sort(stationList);

        List<Station> res=new ArrayList<>();
        int last=0;
        for(Station station:stationList){
            if (station.start>=last){
                res.add(station);
                last=station.end;
            }
        }

        for(Station station:res){
            System.out.print(station.name+" ");
        }

        System.out.println(stationList.get(0).name);

    }
}
