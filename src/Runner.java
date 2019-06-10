import pubsub.Event;
import pubsub.Message;

public class Runner {

	public static void main(String[] args) {		
		Event.on.subscribe("action#create", m -> print(1,m));
		Event.on.subscribe("action#create", m -> print(2,m));
		Event.on.subscribe("action#update", m -> print(3,m));
		Event.on.subscribe("action#delete", m -> print(4,m));

		Message<String> message1 = new Message<>("Create Action");
		Message<String> message2 = new Message<>("Update Action");
		Message<String> message3 = new Message<>("Delete Action");
		
		Event.on.publish("action#create", message1);
		Event.on.publish("action#update", message2);
		Event.on.publish("action#delete", message3);
	}
	public static void print(int id, Message<String>  m) {
		System.out.printf("Subscriber[%d] received: %s%n", id, m.open());
	}
}