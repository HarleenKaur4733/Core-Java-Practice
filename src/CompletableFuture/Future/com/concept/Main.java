package CompletableFuture.Future.com.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecuter = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // Use case 1:

        // A {@code Future} is an interface which represents the result of an
        // asynchronous computation.

        Future<?> futureObj = poolExecuter.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("Task to be executed by thread");
            } catch (Exception e) {
                // TODO: handle exception
            }
        });

        System.out.println("is Done: " + futureObj.isDone());

        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Timeout exception");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            futureObj.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Future.cancel(boolean mayInterruptIfRunning) : Attempts to cancel execution
        // of this task.
        // This attempt will fail if the task
        // has already completed, has already been cancelled, or could not be cancelled
        // for some other reason.

        System.out.println("is Done: " + futureObj.isDone());
        System.out.println("is Cancelled: " + futureObj.isCancelled());

        futureObj.cancel(true);
        System.out.println("is Cancelled now: " + futureObj.isCancelled());

        // Use case 2:
        // The main purpose of Callable is:
        // To run code in a separate thread that returns a result and can throw
        // exceptions.

        // callable is just like runnable. We use callable
        // when we have to return something

        List<Integer> output = new ArrayList<>();
        // want to know why its wrapped in future
        Future<List<Integer>> futureObj2 = poolExecuter.submit(() -> {
            output.add(100);
            System.out.println("Task 2 with runnable and return object");
        }, output);

        // System.out.println("Output: " + output.get(0));
        // above line will return error, abhi task nhi hua complete
        // get method call kro fr woh task complete krk dega

        try {
            // So internally, when you call futureObj2.get(),
            // it simply gives back the same object (output) that you passed in.
            List<Integer> listObj = futureObj2.get();

            System.out.println("Output from listObj: " + listObj.get(0));
            System.out.println("Output: " + output.get(0));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Use case : 3
        Future<List<Integer>> futureObj3 = poolExecuter.submit(() -> {
            System.out.println("Task 3 with callable");
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        });

        try {
            List<Integer> result = futureObj3.get();
            System.out.println("Result from use case 3: " + result.get(0));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
