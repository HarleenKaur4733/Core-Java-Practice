package Threads.com.threads;

public class SharedResource {
    boolean isItemPresent = false;

    public synchronized void addItem() {
        isItemPresent = true;
        System.out.println("Producer thread calling notify method");

        // wait is over now
        notifyAll();
    }

    public synchronized void consumeItem() {

        System.out.println("Consumer thread inside consumeItem method");
        // to avoid any spurious wakeup
        while (!isItemPresent) {
            try {
                System.out.println("Consumer thread is waiting");

                wait(); // release all the monitor locks here
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Consumer thread consume the item");

        isItemPresent = false;
    }
}