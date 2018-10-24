package mini_metro.event;


import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public final class EventService {

    // Store all incoming events
    private static final List<Event> events = new ArrayList<>();
    private static boolean debug = false;

    // Add an event to be sent to GUI
    public static void add(Event evt) {
        events.add(evt);
        if (debug) {             // Useful for tracing
            out.println(events);
        }
    }

    // Remove and return event. Called at frame rate speed in GUI
    public static Event remove() {
        if (events.size() > 0) {
            return events.remove(0);
        } else {
            return null;
        }
    }

}
