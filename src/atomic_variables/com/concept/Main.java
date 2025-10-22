package atomic_variables.com.concept;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 200; i++) {
                sharedResource.increment();
            }

        });

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 400; i++) {
                sharedResource.increment();
            }

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        int val = sharedResource.get();
        System.out.println("Final value: " + val);

    }

}
