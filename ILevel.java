package mini_metro.model.levels;


import mini_metro.model.Line;
import mini_metro.model.Station;
import mini_metro.model.Train;

import java.util.List;

public interface ILevel {

    List<Station> getStations();
    List<Line> getLines();
    List<Train> getTrains();

}
