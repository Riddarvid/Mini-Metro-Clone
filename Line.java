package mini_metro.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Station> stations;

    private void addStation (int index, Station s){
        stations.add(index, s);
    }

    public Line(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }
}
