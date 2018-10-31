package mini_metro.model.levels;

import mini_metro.model.Line;
import mini_metro.model.Passenger;
import mini_metro.model.Station;
import mini_metro.model.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Level0 implements ILevel {

    List<Station> stations=new ArrayList<>();
    List<Line> lines=new ArrayList<>();
    List<Train> trains=new ArrayList<>();

    public Level0(){
        Station a=new Station(100, 100, Station.Type.CIRCLE);
        Station b=new Station(200, 300, Station.Type.SQUARE);
        Station c=new Station(400, 300, Station.Type.TRIANGLE);
        Station d=new Station(200, 400, Station.Type.TRIANGLE);
        Station e=new Station(200, 100, Station.Type.CIRCLE);
        stations.add(a);
        stations.add(b);
        stations.add(c);
        stations.add(d);
        stations.add(e);
        Line yellow=new Line(new ArrayList<>(Arrays.asList(a, b, c)));
        Line red=new Line(new ArrayList<>(Arrays.asList(e, b, d)));
        Line purple=new Line(new ArrayList<>(Arrays.asList(a, e, c, b, d, a)));
        lines.add(yellow);
        lines.add(red);
        lines.add(purple);
        Train yellow1=new Train(yellow);
        Train red1=new Train(red);
        Train purple1=new Train(purple);
        trains.add(yellow1);
        trains.add(red1);
        trains.add(purple1);
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
