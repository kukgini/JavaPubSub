import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pubsub.Event;
import pubsub.Message;

public class Runner {

	private static final ExecutorService executors = Executors.newCachedThreadPool();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {		
		Event.on.subscribe("action#create", m -> executors.submit(() -> print(1,m)));
		Event.on.subscribe("action#create", m -> executors.submit(() -> print(2,m)));
		Event.on.subscribe("action#update", m -> executors.submit(() -> print(3,m)));
		Event.on.subscribe("action#delete", m -> executors.submit(() -> print(4,m)));

		Message<String> message1 = new Message<>("Create Action");
		Message<String> message2 = new Message<>("Update Action");
		Message<String> message3 = new Message<>("Delete Action");
		
		Event.on.publish("action#create", message1);
		Event.on.publish("action#update", message2);
		Event.on.publish("action#delete", message3);
	}
	public static void print(int id, Message<String>  m) {
		String s = m.open();
		System.out.printf("Subscriber[%d] received: %s on thread[%d]%n", id, s, Thread.currentThread().getId());
	}
}