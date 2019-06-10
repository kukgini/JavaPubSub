package pubsub;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Event {
    static {
        init();
    }

    @SuppressWarnings("rawtypes")
	protected static ConcurrentHashMap<String, ConcurrentHashMap<Integer, Consumer<Message>>> channels;
    public static Operation on;

    public static void init() {
        channels = new ConcurrentHashMap<>();
        on = new Operation();
    }
}