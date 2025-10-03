package consumer_producer.com.cp;

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producer = new Thread(() -> {
            System.out.println("Producer thread is running with name" + Thread.currentThread().getName());
            sharedResource.addItem("a");

            sharedResource.addItem("b");
            sharedResource.addItem("c");
            sharedResource.addItem("d");
            sharedResource.addItem("e");
            sharedResource.addItem("f");
            sharedResource.addItem("g");
            sharedResource.addItem("h");

        });

        Thread consumer = new Thread(() -> {

            System.out.println("Consumer thread is running with name" + Thread.currentThread().getName());
            sharedResource.remove();
            sharedResource.remove();
            sharedResource.remove();
            sharedResource.remove();
            sharedResource.remove();
            sharedResource.remove();
            sharedResource.remove();

        });

        producer.start();
        consumer.start();
    }
}
