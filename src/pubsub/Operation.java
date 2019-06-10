package pubsub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class Operation extends Event {
    public void subscribe(String channelName, Consumer<Message> subscriber) {
        if (!channels.containsKey(channelName)) {
            channels.put(channelName, new ConcurrentHashMap<>());
        }
        channels.get(channelName).put(subscriber.hashCode(), subscriber);
    }

    @SuppressWarnings("rawtypes")
	public void publish(String channelName, Message message) {
        for(Map.Entry<Integer, Consumer<Message>> subs : channels.get(channelName).entrySet()) {
            Consumer<Message> subscriber = subs.getValue();
            subscriber.accept(message);
        }
    }
}