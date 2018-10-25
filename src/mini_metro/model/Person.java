package mini_metro.model;
import java.util.List;
import java.util.Random;

public class Person implements IPositionable{

    private final static Random rand=new Random();

    Station destination;
    Station current;
    Station nextStation;

    double x;
    double y;
    double width;
    double height;

    Person(List<Station> stations){
        current=stations.get(rand.nextInt(stations.size()));
        stations.remove(current);
        destination=stations.get(rand.nextInt(stations.size()));
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
}
