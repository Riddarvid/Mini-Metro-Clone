package mini_metro.model.levels;


import mini_metro.model.Station;

import java.util.ArrayList;
import java.util.List;


public final class LevelUtils {

    public void connect(Station a, Station b){
        a.addConnection(b);
        b.addConnection(a);
    }


}
