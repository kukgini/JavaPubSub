package pubsub;

public class Message<T> {
    private T message;

    public Message(T message) {
        this.message = message;
    }
    
    public T open() {
    	return message;
    }
}