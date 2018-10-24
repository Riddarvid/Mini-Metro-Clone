package mini_metro.test;
import mini_metro.model.Station;
import mini_metro.model.levels.Level0;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Test {

    public static void main(String[] args) {
        new Test().program();
    }


    private void program(){

        Level0 level=new Level0();
        List<Station> stations=level.getStations();
        out.println(distance(stations.get(0), stations.get(5)));
    }


    public int distance (Station a, Station b){
        List<Station> explored=new ArrayList<>();
        List<Station> toExplore=new ArrayList<>();
        List<Station> unexplored;
        List<Station> latestRing=new ArrayList<>();
        latestRing.add(a);
        int distance=0;
        boolean done=false;

        while (!done){
            distance++;
            int old=latestRing.size();
            for (int i=0; i<old; i++){
                unexplored=getNew(latestRing.get(i), explored);
                toExplore.addAll(unexplored);
                explored.addAll(unexplored);
                latestRing.addAll(unexplored);
            }
            if (latestRing.contains(b)){
                return distance;
            }
        }
        return -1;
    }

    public List<Station> getNew(Station s, List<Station> explored){
        List<Station> unexplored=new ArrayList<>();
        for (Station c:s.getConnectedStations()){
            if (!explored.contains(c)){
                unexplored.add(c);
            }
        }
        return unexplored;
    }
}
