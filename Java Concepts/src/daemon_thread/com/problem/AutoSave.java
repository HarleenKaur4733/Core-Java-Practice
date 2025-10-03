package daemon_thread.com.problem;

// Problem Statement:
// You are simulating a text editor program.The program has:
// A user thread that simulates typing text(prints"Typing: <some text>"every second).
// A daemon thread that simulates auto-save(prints"Auto-saving..."every 2 seconds).
// Requirements:
// The user thread should run for 10 seconds,simulating typing.
// The auto-save thread should run in the background but stop automatically when the user thread finishes.
// Ensure that auto-save does not block program exit.

public class AutoSave {

    public static void main(String[] args) {

        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Typing...");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        });

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Autosaving");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        });

        // automatically stops when all the user thread stops
        daemonThread.setDaemon(true);

        userThread.start();
        daemonThread.start();

    }

}
