import pubsub.OnReceived;
import pubsub.Message;

class Subscriber<T> {
    int id;
    public Subscriber(int id) {
        this.id = id;
    }

    @OnReceived
    private void onReceived(Message<T> envelop) {
        System.out.printf("Subscriber[%d] received: %s%n", id, envelop.open());
    }
}