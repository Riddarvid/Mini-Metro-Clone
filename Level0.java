package mini_metro.model.levels;



import mini_metro.model.Line;
import mini_metro.model.Station;
import mini_metro.model.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mini_metro.model.levels.LevelUtils.*;

/*
    Basic level to test ships and movement of

 */
public class Level0 implements ILevel {

    List<Station> stations=new ArrayList<>();
    List<Line> lines=new ArrayList<>();
    List<Train> trains=new ArrayList<>();

    public Level0(){
        Station a=new Station(100, 100, "A");
        Station b=new Station(200, 300, "B");
        Station c=new Station(400, 300, "C");
        Station d=new Station(200, 400, "D");
        Station e=new Station(200, 100, "E");
        stations.add(a);
        stations.add(b);
        stations.add(c);
        stations.add(d);
        stations.add(e);
        Line yellow=new Line(new ArrayList<>(Arrays.asList(a, b, c)));
        Line red=new Line(new ArrayList<>(Arrays.asList(e, b, d)));
        lines.add(yellow);
        lines.add(red);
        Train yellow1=new Train(yellow);
        Train red1=new Train(red);
        trains.add(yellow1);
        trains.add(red1);
    }





    @Override
    public List<Station> getStations() {
        return stations;
    }

    @Override
    public List<Line> getLines() {
        return lines;
    }

    @Override
    public List<Train> getTrains() {
        return trains;
    }


}
