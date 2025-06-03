package Multithreading;

//DeadLock typically occur when four conditions are met simultaneously:
//1. Mutual Exclusion: Only one thread can access a resource at a time.
//2. Hold and Wait: A thread holding at least one resource is waiting to acquire additional resources held by other threads.
//3. No Preemption: Resources cannot be forcibly taken from threads holding them.
//4. Circular wait: A set of threads is waiting for each other in a circular chain.

//Thread Communication
//Without proper thread communication mechanisms, threads might end up in inefficient busy-waiting states where each thread need to check repeatedly whether the resource is free or not leading to waste of CPU resources and potential deadlocks.
//To avoid this, thread communication is done by 3 useful methods:
//1. wait(): tells the current thread to release the lock and indefinitely waits until any other thread calls notify() or notifyAll().
//2. notify(): wakes up a single thread that is waiting to acquire this lock
//3. notifyAll(): wakes up all threads that are waiting to acquire this lock
//These methods can only be called within a synchronized context(synchronized block,method)

class Pen
{
    public synchronized void writeWithPenAndPaper(Paper paper)
    {
        //synchronized keyword makes the thread acquire the intrinsic lock of the object to which this method belong.
        System.out.println(Thread.currentThread().getName()+" is using pen and trying to use paper");
        paper.finishWriting();
    }
    public synchronized void finishWriting()
    {
        System.out.println(Thread.currentThread().getName()+" finished writing using pen");
    }
}
class Paper
{
    public synchronized void writeWithPaperAndPen(Pen pen)
    {
        System.out.println(Thread.currentThread().getName()+" is using paper and trying to use pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting()
    {
        System.out.println(Thread.currentThread().getName()+" finished writing using paper");
    }
}
class Task1 implements Runnable
{
    private Pen pen;
    private Paper paper;

    Task1(Pen pen,Paper paper)
    {
        this.pen=pen;
        this.paper=paper;
    }

    @Override
    public void run()
    {
        pen.writeWithPenAndPaper(paper); //locks pen and tries to lock paper
    }
}
class Task2 implements Runnable
{
    private Pen pen;
    private Paper paper;

    Task2(Pen pen,Paper paper)
    {
        this.pen=pen;
        this.paper=paper;
    }

    @Override
    public void run()
    {
        //paper.writeWithPaperAndPen(pen); //locks paper and tries to lock pen which can lead to deadlock since pen is already locked by another thread

        synchronized (pen) // this synchronized block will prevent deadlock by ensuring that the paper is locked only when the pen is free(i.e., when the another thread does its work).
        {
            paper.writeWithPaperAndPen(pen);
        }
    }
}
public class DeadLock
{
    public static void main(String[] args)
    {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1=new Thread(new Task1(pen,paper),"Thread-1");
        Thread thread2=new Thread(new Task2(pen,paper),"Thread-2");
        thread1.start();
        thread2.start();
    }
}
