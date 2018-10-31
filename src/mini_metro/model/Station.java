package mini_metro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station implements IPositionable {

    private List<Station> connectedStations=new ArrayList<>();

    private final double x;
    private final double y;
    private static final double diameter=15;
    private List<Passenger> passengers=new ArrayList<>();
    private final Type type;

    public enum Type{
        SQUARE,
        CIRCLE,
        TRIANGLE
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
        p.setX(this.x);
        p.setY(this.y);
    }

    public void removePassenger(Passenger p){
        passengers.remove(p);
    }


    public Station(double x, double y, Type type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void addConnection (Station station){
        connectedStations.add(station);
    }

    public List<Station> getConnectedStations() {
        return connectedStations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
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

    public Type getType() {
        return type;
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
                Objects.equals(type, station.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectedStations, x, y, diameter, type);
    }

    public static double getDiameter() {
        return diameter;
    }
}
