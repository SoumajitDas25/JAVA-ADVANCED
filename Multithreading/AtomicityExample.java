package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter
{
    private AtomicInteger counter = new AtomicInteger(0); //Atomicity is achieved here using Atomic data type cause now only one thread can access it at one time(Isolation), making it Thread Safe.
    //making it volatile here won't work cause volatile only makes the thread to get/set from memory, it won't cause any locking of resource
    //Alternatively, we can also use synchronized or manual locks here.
    public void increment()
    {
        this.counter.incrementAndGet();
    }
    public int getCounter()
    {
        return this.counter.get();
    }
}
public class AtomicityExample
{
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++)
            {
                counter.increment();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<1000;i++)
            {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCounter());
    }
}
