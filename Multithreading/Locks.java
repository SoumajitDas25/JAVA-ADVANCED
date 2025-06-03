package Multithreading;

//Whenever synchronization is done, the shared resource which is accessed by one thread at a time is locked by the thread i.e., the thread acquires the lock due to which other threads can't access the resource at that time.

//Locks are of two types:
//1. Intrinsic: These are built into every object in Java, we don't see them, but they are there. When we use a synchronized keyword, we are using these automatic locks. Here, we don't have control over the locking mechanism(when to lock and when to unlock).
//2. Explicit: These are more advanced locks which we can control ourself by implementing the Lock interface from java.util.concurrent.locks. We explicitly control when to lock and unlock.

//Lock interface has three useful methods which its implementation class(ReentrantLock class) implements:
//1. lock()- indefinitely waits & acquires the lock.
//2. tryLock()- acquires the lock & returns true if its free at the time of its invocation else immediately returns false.
//   tryLock(time,TimeUnit)- acquires the lock & returns true if its free within the given waiting time & the current thread has not been interrupted else returns false(this method throws InterruptedException so it needs to be handled).
//3. unlock()- releases the lock
//4. lockInterruptibly() -

//deadlock condition- when one thread waits for another thread which in turn waits for the first thread.
//deadlock can be prevented using Reentrancy where one thread gets locked again & again & needs to be unlocked again & again (Each lock must be unlocked).

//Fairness of lock- every thread gets a chance to execute preventing starvation condition(where a thread doesn't gets the chance to execute due to other threads) & are executed in the order of their request(order of request depends on the thread scheduler).

//Disadvantages of Synchronization
//1. No guarantee of fairness
//2. Indefinite Blocking/Waiting
//3. No Interruptibility
//4. No Read/Write distinction

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks
{
    private final Lock lock=new ReentrantLock(true);//passing true makes it a fair lock

    public void accessResources()
    {
        lock.lock();
        try
        {
            System.out.println(Thread.currentThread().getName()+" acquired the lock");
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        finally
        {
            System.out.println(Thread.currentThread().getName()+" released the lock");
            lock.unlock();
        }
    }
    public static void main(String[] args)
    {
        Locks locks=new Locks();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                locks.accessResources();
            }
        };
        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
        Thread t3=new Thread(task,"Thread 3");

        try
        {
            t1.start();
            Thread.sleep(50);
            t2.start();
            Thread.sleep(50);
            t3.start();
            Thread.sleep(50);
        }
        catch (InterruptedException e)
        {
            System.out.println("Main Thread Interrupted");
        }
    }
}