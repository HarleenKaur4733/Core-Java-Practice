package lock_and_condition.read_write_lock.com.concept;

import java.util.concurrent.locks.ReadWriteLock;

// if read lock is aquired by a code, then it cant have write lock. It can have other read lock.
// if write lock is aquired by a code, then it can't have read or write lock
// Read lock: S (Shared lock)
// Write lcok: X (Exclusive lock)
public class SharedResource {
    int data = 2;

    public void readData(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            System.out.println("Data read: " + data);
            Thread.sleep(8000);
        } catch (Exception e) {
            System.out.println("Error occurred " + e);
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("Read lock released by " + Thread.currentThread().getName());
        }
    }

    public void writeData(ReadWriteLock readWriteLock) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            data = 7;
            System.out.println("Data written: " + data);
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("Write lock released by " + Thread.currentThread().getName());
        }
    }

}
