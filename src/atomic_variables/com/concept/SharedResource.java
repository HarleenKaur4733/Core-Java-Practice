package atomic_variables.com.concept;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {

    // int counter = 0;
    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        // counter++;
        counter.incrementAndGet(); // click this method to see CAS
    }

    // public final int getAndAddInt(Object o, long offset, int delta) {
    // int v;
    // do {
    // v = getIntVolatile(o, offset);
    // } while (!weakCompareAndSetInt(o, offset, v, v + delta));
    // return v;
    // }

    public int get() {
        // return counter;
        return 0;
    }
}

// This line: counter++;
// is not atomic.It actually consists of three separate steps under the hood:

// Read the current value of counter
// Add 1 to it
// Write the new value back

// If two threads do this at the same time, their operations can overlap:
// Thread 1 Thread 2
// Counter Reads 10 Reads 10 10 Adds 1→11 Adds 1→11 10(
// both used
// same old value)Writes 11 Writes 11✅
// Lost one increment!

// So you lose updates— leading to inconsistent final results
