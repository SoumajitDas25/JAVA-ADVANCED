package Multithreading.ExecutorsFramework;

import java.util.concurrent.*;

public class ExecutorServiceMethods
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(3); //this will create a thread pool of n-reusable threads
        //ExecutorService executor1 = Executors.newSingleThreadExecutor(); //this will create a single reusable thread

        //submit() is overloaded to have 3 signatures for 3 three diff types of params
        //submit() returns a Future type object representing the task &  will contain the return value(if any) & some methods
        Future<?> future1 = executor.submit(() -> System.out.println("Hello"));//here, submit() accepts a Runnable type object whose run() is overrided here (since the implementation for the abstract method doesn't returns anything here, so it will be considered the implementation of run() of runnable type)

        Future<Integer> future2 = executor.submit(() -> 34);//here, submit() accepts a Callable type object whose call() is overrided here (since the implementation for the abstract method returns something here, so it will be considered the implementation of call() of callable type)

        Future<String> future3 = executor.submit(() -> System.out.println("Hi"), "Success"); //here, submit() accepts a Runnable type object and a value to be returned


        try {
            System.out.println(future1.get()); //get() will wait for the thread to complete the task though here it will return null cause it won't receive any value from run().

            System.out.println(future1.isDone()); //isDone() returns true if the task is completed(completion may be either due to normal termination,exception or cancellation) but it won't wait for the task to complete.

            System.out.println(future2.get()); //here get() will wait for the thread to complete the task & fetch the returned value from the call().

            System.out.println(future3.get()); //here get() will wait for the thread to complete the task & return the value which we passed as param.

            //System.out.println(future3.get(1,TimeUnit.SECONDS)); //here get() will wait for the thread to complete the task until the specified time else it will throw a TimeOutException if the task has not completed within the timeOut duration.

            //System.out.println(future2.cancel(true)); //cancels the task execution (if passed true, will cancel it while it is executing, if passed false, will cancel it only if its not started to execute or has executed).

            //System.out.println(future2.isCancelled()); //returns true if the task was cancelled before it completed normally.
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } //catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        }

        executor.shutdown(); //it will make a shutdown request & start orderly shutdown in which previously submitted tasks will be executed but no new task will be accepted to submit(here,this method won't cause any block/wait i.e., the main thread won't wait for this method to complete its shutdown process,so to wait, we have to use awaitTermination())

        //executor.isTerminated(); //returns true if all tasks are completed after the shutdown request

        //executor.isShutdown(); //returns true if the executor has been shutdown

        //executor.shutdownNow(); //immediately shutdowns by stopping all actively executing tasks

        //executor.awaitTermination(5,TimeUnit.SECONDS); //awaits/blocks until all tasks are completed after a shutdown request or the timeout occurs
    }
}