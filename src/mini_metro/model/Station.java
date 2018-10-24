package mini_metro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station implements IPositionable {

    private List<Station> connectedStations=new ArrayList<>();

    private final double x;
    private final double y;
    private final double diameter=15;
    private final String name;


    public Station(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public void addConnection (Station station){
        connectedStations.add(station);
    }

    public List<Station> getConnectedStations() {
        return connectedStations;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return diameter;
    }

    @Override
    public double getHeight() {
        return diameter;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Double.compare(station.x, x) == 0 &&
                Double.compare(station.y, y) == 0 &&
                Double.compare(station.diameter, diameter) == 0 &&
                Objects.equals(connectedStations, station.connectedStations) &&
                Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectedStations, x, y, diameter, name);
    }
}
