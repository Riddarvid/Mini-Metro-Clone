package mini_metro.event;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public final class EventService {

    private static final List<Event> events = new ArrayList<>();
    private static boolean debug = false;

    public static void add(Event evt) {
        events.add(evt);
        if (debug) {
            out.println(events);
        }
    }

    public static Event remove() {
        if (events.size() > 0) {
            return events.remove(0);
        } else {
            return null;
        }
    }

}
