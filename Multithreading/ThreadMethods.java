package Multithreading;

public class ThreadMethods extends Thread
{
    public ThreadMethods(String name) //accepts thread name
    {
        super(name);
    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(5000); //sleep() makes the current thread to sleep for the specified duration(in ms).
            //sleep() is declared itself in method signature to throw InterruptedException which is a Checked Exception if it is interrupted,so we must need to wrap it inside try-catch.
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted Exception by Thread "+Thread.currentThread().getName()+" "+Thread.currentThread().isInterrupted()); // here, the isInterrupted() will print false as the interruption status is reset to false when the exception is thrown(before entering the catch block).
        }
        System.out.println("Hello by Thread "+Thread.currentThread().getName()); // this will be printed even if the InterruptionException is thrown, cause it will be catched and the execution is continued.

        for(int i=1;i<=10;i++)
        {
            System.out.println("Thread "+Thread.currentThread().getName()+" is running");
            Thread.yield(); //yield() gives a hint to the scheduler that this current thread which is running this method is willing to give its chance to another threads, although this hint can be ignored by the scheduler.
        }

    }

    public static void main(String[] args) throws InterruptedException
    {
        ThreadMethods t1 = new ThreadMethods("t1");
        ThreadMethods t2 = new ThreadMethods("t2");
        ThreadMethods t3 = new ThreadMethods("Daemon");
        t1.start();
        t2.start();

//        t1.join(); //this makes the thread who is running this method(here,main thread) to wait until t1 thread has finished its execution
        //join() is also declared to throw InterruptedException, so here, main() is declared to throw it.

//        t1.interrupt(); //this interrupts the thread to exit from sleep, wait or join & sets the interruption flag to true while continuing the execution(note: this method doesn't throw InterruptedException only it sets the interruption status to true).
        //sleep(), wait() & join() throws an Interrupted Exception when interrupted.
        //whenever an InterruptedException is thrown, JVM automatically resets the interruption status to false.

        //User-Threads- Threads which we explicitly create to carry out our tasks (here, t1 & t2).
        //Daemon-Threads- Threads which are running in the background.
        //JVM waits for all the user-threads to complete their execution whereas it doesn't waits for the daemon-threads.
        t3.setDaemon(true); //it will make this thread as daemon thread which means that JVM won't wait for its execution to finish when all other user threads have finished their execution.
        t3.start();
    }
}
