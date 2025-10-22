package lock_and_condition.read_write_lock.com.concept;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// There must be shared code
public class Main {
    public static void main(String[] args) {
        SharedResource obj1 = new SharedResource();
        // SharedResource obj2 = new SharedResource();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Thread readThread = new Thread(() -> {
            obj1.readData(readWriteLock);

        });

        Thread readThread2 = new Thread(() -> {
            obj1.readData(readWriteLock);

        });

        Thread writeThrad = new Thread(() -> {
            obj1.writeData(readWriteLock);
        });

        readThread.start();
        readThread2.start();
        writeThrad.start();

    }
}
