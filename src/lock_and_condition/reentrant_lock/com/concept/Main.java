package lock_and_condition.reentrant_lock.com.concept;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        SharedResource obj1 = new SharedResource();
        Thread t1 = new Thread(() -> {
            obj1.produce(lock);
        });

        SharedResource obj2 = new SharedResource();
        Thread t2 = new Thread(() -> {
            obj2.produce(lock);
        });

        t1.start();
        t2.start();
    }
}
