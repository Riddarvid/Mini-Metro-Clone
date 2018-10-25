package mini_metro.model;

import mini_metro.model.levels.ILevel;
import mini_metro.model.levels.Level0;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class World {

    public static final double GAME_WIDTH = 800;
    public static final double GAME_HEIGHT = 500;


    private List<Line> lines;
    private List<Station> stations;
    private ILevel level;
    private List<Train> trains;

    public World (ILevel level){
        this.level=level;
        stations=level.getStations();
        lines=level.getLines();
        trains=level.getTrains();
    }


    public void update(long now){
        updateTrains(now);
    }


    public void updateTrains(long now){
        for (Train t:trains){
            if (t.isAtStation()){
                if (now-t.getArrivalTime()>500_000_000){
                    out.println(now-t.getArrivalTime());
                    t.newDest();
                    t.setAtStation(false);
                }
            } else {
                t.move();
                if (t.hasArrived(now)){
                    t.setArrivalTime(now);
                    t.setAtStation(true);
                }
            }

        }
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
            for (Station s:latestRing){
                unexplored=getNew(s, explored);
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

    public List<Line> getLines() {
        return lines;
    }

    public List<Station> getStations() {
        return stations;
    }

    public List<Train> getTrains() {
        return trains;
    }
}
