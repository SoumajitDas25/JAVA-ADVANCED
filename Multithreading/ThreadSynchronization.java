package Multithreading;

class Counter
{
    private int count;

    public int getCount()
    {
        return count;
    }
    public synchronized void increment() //synchronized method- only one thread will run this method at one time while other threads will wait.
    {
        count++; //since both threads share this same object so both will try to make changes(read & increment here) simultaneously which will lead to incorrect results.
        //So, to avoid this, synchronized keyword is used to declare a synchronized method or block which will ensure that only one thread will run the method or block at one time while another threads will wait for it.
        //A method or a block can be made synchronized using this keyword.
        //The section where shared resource is accessed is called the critical section.
        //synchronization helps to achieve mutual exclusion.

//            synchronized (this) //synchronized block- only one thread will                run this block at one time while other threads will wait.
//            { //this refers to the object which is shared between multiple                    threads.
//                count++;
//            }
    }
}

public class ThreadSynchronization extends Thread
{
    private Counter counter;

    public ThreadSynchronization(Counter counter)
    {
        this.counter=counter;
    }
    @Override
    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            counter.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Counter c = new Counter();
        ThreadSynchronization t1 = new ThreadSynchronization(c);
        ThreadSynchronization t2 = new ThreadSynchronization(c); // c is a shared resource here cause it is shared by these 2 threads.
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.getCount());
    }
}
