package producer_consumer.com.problem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    Queue<Integer> queue;
    int buffer;

    SharedResource(int buffer) {
        queue = new LinkedList<>();
        this.buffer = buffer;
    }

    // consume : remove
    public synchronized void consumeProduct() {
        while (queue.isEmpty()) {
            try {
                System.out.println(
                        "Remove monitored locks from ProduceProduct function. Waiting for elements to add so as to run remove operation");
                wait();
            } catch (Exception e) {

            }
        }

        int itemRemoved = queue.remove();
        System.out.println("Item removed " + itemRemoved);
        notify();
        System.out.println("########## Notification of item removed sent ############");
    }

    // produce : add
    public synchronized void produceProduct(int item) {
        while (queue.size() == buffer) {
            try {
                System.out.println(
                        "Remove monitored locks from ConsumeProduct function. Waiting for elements to remove so as to run add operation");
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block

            }
        }

        queue.add(item);
        System.out.println("Item added " + item);
        notify();
        System.out.println("########## Notification of item added sent ############");
    }

}
