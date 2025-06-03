package Multithreading.ExecutorsFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMethods
{
    public static void main(String[] args)
    {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //ExecutorService scheduler2 = Executors.newCachedThreadPool(); //Creates a thread pool that dynamically adds and removes threads as needed, new threads are added when there are no threads available for executing tasks and threads after 60 secs of inactivity will be terminated and removed.

        scheduler.schedule(()->System.out.println("Hii after 5 secs initial delay"),5, TimeUnit.SECONDS); //schedules the one time task after specified initial delay.

        //scheduler.scheduleAtFixedRate(()->System.out.println("Hii after every 3 secs after 5 secs initial delay"),5,3, TimeUnit.SECONDS); //schedules the periodic task after specified initial delay.

        //whenever periodic tasks are scheduled, the shutdown is not done immediately without proper handling cause it will not allow the periodic tasks to execute rather shutdown is also scheduled after a specified delay.
        //scheduler.schedule(()->{
           // System.out.println("Inititiating Shut down");
           // scheduler.shutdown();
        //},10,TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
