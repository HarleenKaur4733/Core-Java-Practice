package CompletableFuture.completable_future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy());

            // note i have provided custom threadPoolExecutor.
            // if not provided, forkpool will be used
            CompletableFuture<String> asynctask1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Thread name whih is running supplyAsync: " + Thread.currentThread().getName());
                return "Concept ";
            }, threadPoolExecutor).thenApply((String val) -> {
                // thenApply is sync function, same thread is used which is
                // used to execute previous async task
                System.out.println("Thread name whih is running thenApply: " + Thread.currentThread().getName());
                return val + "and Coding";
            });

            System.out.println(asynctask1.get());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
