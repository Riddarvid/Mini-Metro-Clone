package mini_metro.model;

import java.util.List;

public class Train implements IPositionable {
    private double x;
    private double y;
    private double distanceX;
    private double distanceY;
    private double dx;
    private double dy;
    private final double height=10;
    private final double width=10;
    private double scaling;
    private final double speed=1;

    private Station destination;
    private Station latest;
    private List<Station> stations;
    private Line line;

    public Train(Line line) {
        this.line = line;
        stations = line.getStations();
        latest = stations.get(0);
        destination = stations.get(1);
        x = stations.get(0).getX();
        y = stations.get(0).getX();
        distanceX = stations.get(1).getX()-x;
        distanceY = stations.get(1).getY()-y;
        scaling = speed/Math.pow(Math.pow(distanceX, 2)+Math.pow(distanceY, 2), 0.5);
        dx = distanceX*scaling;
        dy = distanceY*scaling;
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public boolean hasArrived(){
        return (dx>=0&&x>=destination.getX()||dx<=0&&x<=destination.getX())&&(dy>=0&&y>=destination.getY()||dy<=0&&y<=destination.getY());
    }

    public void newDest(){
        if (destination.equals(stations.get(0))){
            destination=stations.get(1);
            latest=stations.get(0);
        } else if (destination.equals(stations.get(stations.size()-1))){
            destination=stations.get(stations.size()-2);
            latest=stations.get(stations.size()-1);
        } else if (stations.indexOf(destination)>stations.indexOf(latest)){
            latest=destination;
            destination=stations.get(stations.indexOf(latest)+1);
        } else {
            latest=destination;
            destination=stations.get(stations.indexOf(latest)-1);
        }

        x = latest.getX();
        y = latest.getY();
        distanceX = destination.getX()-x;
        distanceY = destination.getY()-y;
        scaling = speed/Math.pow(Math.pow(distanceX, 2)+Math.pow(distanceY, 2), 0.5);
        dx = distanceX*scaling;
        dy = distanceY*scaling;
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
