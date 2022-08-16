import com.abhisheksingh.concurrency.AnotherThread;
import com.abhisheksingh.concurrency.MyRunnable;

import static com.abhisheksingh.concurrency.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("++ Another thread ++");
        anotherThread.start();
        new Thread () {
            @Override
            public void run() {
                System.out.println(ANSI_GREEN + "Hello fom the anonymous class thread");
            }
        }.start();
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class implementation of the run()");
                try{
                    anotherThread.join(3000);
                    System.out.println("Another thread terminated or timed out , so I'm running again");
                }
                catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all . I was interrupted ");
                }
            }
        });
        anotherThread.interrupt();
        myRunnableThread.start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread");


    }
}