package Threads.com.threads;

// synchronized works on object level...
public class Main {

    public static void main(String[] args) {

        SharedResource sharedResourceObj = new SharedResource();

        Thread producerThread = new Thread(() -> { // accept the implementation of runnable interface

            // delaying it on purpose to execute consumer thread first
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            sharedResourceObj.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            sharedResourceObj.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
    }

}
