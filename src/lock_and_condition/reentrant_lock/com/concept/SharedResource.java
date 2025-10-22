package lock_and_condition.reentrant_lock.com.concept;
// ReentrantLock

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    // Reentrant Lock for a critical section, not for object
    public void produce(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("Running thread " + Thread.currentThread().getName());

            Thread.sleep(5000);

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println("Closing thread " + Thread.currentThread().getName());
            lock.unlock();
        }

    }
}
