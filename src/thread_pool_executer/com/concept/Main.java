package thread_pool_executer.com.concept;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandler());

        pool.allowCoreThreadTimeOut(true);

        // Submitting 4 tasks to threadpool
        for (int i = 0; i < 8; i++) {
            pool.submit(() -> {
                try {
                    Thread.sleep(5000);

                } catch (Exception e) {
                    // handle exception
                }

                // task to be performed
                System.out.println("Performing task with thread " + Thread.currentThread().getName());
            });
        }

        pool.shutdown();
    }
}

// Create this if you want to add some custom properties to thread,
// otherwise default one can also be used.
// By default, the ThreadPoolExecutor uses Executors.defaultThreadFactory()

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {

        Thread t1 = new Thread(r);

        t1.setDaemon(false);
        t1.setPriority(5);
        return t1;
    }

}

class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        System.err.println("Task denied " + r.toString());
    }

}
