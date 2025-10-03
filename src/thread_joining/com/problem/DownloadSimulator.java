package thread_joining.com.problem;

// 📝Problem:File Download Simulation

// You are simulating downloading 3 files in parallel.Each file takes a few seconds to“download”(just use Thread.sleep()to simulate time).

// Create 3 worker threads:
// FileDownloader1(takes 2 s)
// FileDownloader2(takes 3 s)
// FileDownloader3(takes 4 s)

// Start all threads together(parallel).

// In the main thread:
// Wait for all 3 downloads to finish using join().
// Then print:
// All files downloaded.Starting installation...

public class DownloadSimulator {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println("Downloading File 1...");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("File 1 downloaded.");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Downloading File 2...");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }
            System.out.println("File 2 downloaded.");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Downloading File 3...");
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }
            System.out.println("File 3 downloaded.");
        });

        // task:
        // 1. Start all 3 threads
        // 2. Use join() so that "installation" only starts after all 3 files are done

        t1.start();
        t2.start();
        t3.start();

        // Hey current (main) thread, wait until t1 thread finishes.
        t1.join();

        // Hey current thread, wait until t2 thread finishes.

        t2.join();

        // Hey current thread, wait until t3 thread finishes.

        t3.join();

        System.out.println("All files downloaded. Starting installation...");
    }
}
