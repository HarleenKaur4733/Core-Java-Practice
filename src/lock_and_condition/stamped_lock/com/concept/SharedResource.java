package lock_and_condition.stamped_lock.com.concept;

import java.util.concurrent.locks.StampedLock;

// Stamped lock lets you:

// Have multiple readers at once(like a read lock).
// Allow one writer at a time(like a write lock).
// Use a special optimistic read—a non-blocking read that doesn’t 
//     stop writers unless data actually changes.

//  ******************************************************************************************
// An optimistic read means reading shared data without actually locking it,
//         assuming that no one else is changing it at that moment.

// It’s like saying:
// “I’ll quickly take a peek—I believe no one is writing right now.”
// If later you find out that a writer did change the data while you 
// were reading,you re-read it safely with a normal read lock.

// In pessimistic, lock is put before reading

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.tryOptimisticRead();
        System.err.println("Checking stamp value: " + stamp);

        try {
            a = 12;
            Thread.sleep(4000);
            // Check if versions are same, if yes, then update it
            if (lock.validate(stamp)) {
                System.out.println("Value updated sucessfully");
            }
        } catch (Exception e) {
            System.out.println("Rollback of work");
            a = 10;
        }

    }

    public void consumer() {

    }
}
