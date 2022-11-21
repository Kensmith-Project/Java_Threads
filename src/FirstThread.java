public class FirstThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
             //Code that will run in a new thread
//                System.out.println("We are now in" + Thread.currentThread().getName());
//                System.out.println("The current Thread priority is " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intentional exception");

            }
        });
        thread.setName(" A Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
//        System.out.println("We are in " + Thread.currentThread().getName() + "before starting a new thread");

//        System.out.println("We are in " + Thread.currentThread().getName() + "after starting a new thread");
        Thread.sleep(1000);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(" A critical condition happened in the main thread " + t.getName() +" and the message is " + e.getMessage());
            }
        });
        thread.start();

    }
}
