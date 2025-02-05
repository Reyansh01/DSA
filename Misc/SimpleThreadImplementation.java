package Misc;

public class SimpleThreadImplementation {
    
    public static void main(String[] args) {
        System.out.println("Starting threads now");
        
        Thread thread = new Thread(() -> {
            System.out.println("Thread 1 is starting..");
        });

        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 is starting..");
            }  
        };

        Thread thread2 = new Thread(runnable, "Thread 2");
        thread2.start();

        Runnable threadRunFunctional = () -> {
            System.out.println("Thread 3 is starting..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception..");
            }
        };
        
        Thread thread3 = new Thread(threadRunFunctional, "Thread 3");
        thread3.setDaemon(true); // to run it in background and let the main thred be executed first..
        thread3.start();

        System.out.println("Main thread finished successfully.");

    }

}
