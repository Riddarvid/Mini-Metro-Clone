package mini_metro.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static java.lang.System.out;

public class Passenger implements IPositionable{

    private final static Random rand=new Random();

    private final Station.Type destination;
    private Station current;
    private Station nextStation;

    private double x;
    private double y;
    private double width=7;
    private double height=7;

    public Passenger(List<Station> stations){
        current=stations.get(rand.nextInt(stations.size()));
        x=current.getX();
        y=current.getY();
        Station.Type[] types=Station.Type.values();
        List<Station.Type> destinations=new ArrayList<>();
        for (Station.Type t:types){
            if(t!=current.getType()){
                destinations.add(t);
            }
        }
        out.println(destinations);
        destination=destinations.get(rand.nextInt(destinations.size()));
        current.addPassenger(this);
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public Station.Type getType() {
        return destination;
    }
}
