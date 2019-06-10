package pubsub;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class Event {
    static {
        init();
    }

    public static Operation on;
    protected static ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<Object>>> channels;

    public static void init() {
        channels = new ConcurrentHashMap<>();
        on = new Operation();
    }
}