import pubsub.Event;
import pubsub.Message;

public class Runner {

	public static void main(String[] args) {
		Subscriber<String> subscriber1 = new Subscriber<>(1);
		Subscriber<String> subscriber2 = new Subscriber<>(2);
		Subscriber<String> subscriber3 = new Subscriber<>(3);
		Subscriber<String> subscriber4 = new Subscriber<>(4);
		
		Event.on.subscribe("action#create", subscriber1);
		Event.on.subscribe("action#create", subscriber2);

		Event.on.subscribe("action#update", subscriber3);
		Event.on.subscribe("action#delete", subscriber4);

		Message<String> message1 = new Message<>("Create Action");
		Message<String> message2 = new Message<>("Update Action");
		Message<String> message3 = new Message<>("Delete Action");
		
		Event.on.publish("action#create", message1);
		Event.on.publish("action#update", message2);
		Event.on.publish("action#delete", message3);
	}
}