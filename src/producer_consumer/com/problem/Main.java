package producer_consumer.com.problem;

// This is the correct solution of producer, consumer problem
public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(4);

        // pass object of class which is created by implmenting runnable interface
        // runnable interface is a functional interface
        // so no need to make an implementation class
        // directly use anonymous function to call run method.
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 7; i++) {
                sharedResource.produceProduct(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                sharedResource.consumeProduct();
            }
        });

        t1.start();
        t2.start();

    }

}
