package Multithreading.ExecutorsFramework;

//Thread pool - Collection of pre-initialized threads
//Advantages of Thread Pool:
//1. Resource Management: Removes Additional manual overheads of creating & destroying threads.
//2. Response time: Faster response time due to no processing overheads of creating & destroying threads.
//3. Control over thread count: we manually define the max no of threads in the pool to be used preventing blind creation of unnecessary threads.

//Executors Framework: Introduced in Java 5 as part of the java.util.concurrent package to simplify the development of concurrent applications by abstracting away many of the complexities involved in creating & managing threads.

//Problems without it:
//1. Manual thread management
//2. Inefficient Resource management
//3. No Thread Reuse
//4. Complex Error handling

// It has 3 core Interfaces:
//1. Executor
//2. ExecutorService
//3. ScheduledExecutorService

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorBasics
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(6); //here Executors is a class containing various utility methods and this method creates a thread pool of n reusable threads & returns an executorService object
        for(int i=0;i<10;i++)
        {
            int finalI = i;
            executor.submit(() -> {
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Hello "+finalI+" from "+Thread.currentThread().getName());
            }); //this method accepts a runnable object where we specify what to execute
        }
        executor.shutdown(); //this will shut down the executor & after this it couldn't be reused for submitting a new task
    }
}
