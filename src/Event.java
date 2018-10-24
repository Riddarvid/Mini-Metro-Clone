package mini_metro.event;

/*
       Events passed from model to GUI

       Possible add own event to here
 */
public class Event {

    // Enumeration of events
    public enum Type {
        BOMB_HIT_GUN,
        BOMB_HIT_GROUND,
        ROCKET_HIT_SHIP,
        SHIP_HIT_GROUND,
        SHIP_HIT_GUN,
        ROCKET_LAUNCHED,
        GAME_OVER,
        BOMB_HIT_ROCKET,
        CHECK_MUSIC,
        DEBUG,
        BOMB_DROPPED,
        EXCEPTION       // Possible useful
    }

    public final Event.Type type;
    public final Object data;  // Possible send some data to GUI

    public Event(Event.Type type, Object data) {
        this.type = type;
        this.data = data;
    }

    public Event(Event.Type type) {
        this(type, null);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
