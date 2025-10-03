package consumer_producer.com.cp;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    boolean isEmpty = true;
    boolean isFull = false;
    Queue<String> queue = new LinkedList<>();

    public synchronized void addItem(String item) {
        System.out.println("Entered the add item method");
        if (queue.size() > 3) {
            System.out.println("QUEUE IS FULLLLLLLLL");
            isFull = true;

        } else {
            isEmpty = false;
        }
        while (isFull) {
            try {
                System.out.println("wait called. Now all monitor locks are released");
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        System.out.println("Adding item: " + item);
        queue.add(item);

    }

    // delay it on purpose
    public synchronized void remove() {
        System.out.println("Entered the remove item method");
        if (queue.size() == 0) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }

        while (isEmpty) {
            try {
                System.out.println("List is empty");
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        if (!isEmpty) {
            System.out.println("Removing the item");

            String item = queue.remove();
            System.out.println("Item removed " + item);

            System.out.println("Wait is over. notify() called");
            notifyAll();
        }
    }
}
