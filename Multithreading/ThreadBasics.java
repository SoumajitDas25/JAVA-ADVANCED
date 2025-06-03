package Multithreading;

//A Core is an individual processing unit of a CPU, a CPU can be single or multi-core depending on its hardware.
//A process is started for each program by the CPU, which are distributed across multiple available cores in case of multi-core CPU or managed in one core by rapid switching between tasks by time-slicing and context-switching in case of single-core CPU.
//Multitasking is achieved by this process management.
//Under each process, there can be multiple sub-tasks executed by individual threads, which are the smallest unit of execution.
//Multithreading is the ability to execute multiple threads to perform multiple tasks within a process simultaneously.

//In Java, by default, for every program, a new thread is started which is called the main thread which runs the main().

//A Thread in java can be created & run by 2 ways:
//1. Extending the Thread class and overriding the run() and then calling the start() on its instance.
//2. Implementing the Runnable Interface and overriding the run() and then passing its instance reference to the constructor of Thread class and calling start() on this Thread class instance.

//A thread lifecycle refers to the different states which a thread goes through from its creation to its termination.
//These states are :-
//1. NEW: Thread is created but not has started to run.
//2. RUNNABLE: After the start() is called, Thread becomes runnable, it is now ready to run & is waiting for CPU time.
//3. RUNNING: Thread is running/executing.
//4. WAITING/BLOCKED: Thread is waiting for a resource or for another thread to perform an action.
//5. TERMINATED: Thread has finished its execution.
//In java, RUNNABLE state is used for both Runnable or Running state.

public class ThreadBasics implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Hello "+Thread.currentThread().getName()+" "+Thread.currentThread().getState()); // Here, currentThread() will return the current thread instance which is running this run(), which is the new Thread created).
    }

    public static void main(String[] args) throws InterruptedException
    {
        ThreadBasics t = new ThreadBasics();
        Thread t1 = new Thread(t); //t1 thread is in New state

        System.out.println(Thread.currentThread().getState()+" "+t1.getState()); //currentThread() returns the instance of the current thread which is running this method which in this case is the main thread which is running this main().
        //static methods of Thread class(like Thread.currentThread()) operates on the current thread which is running this method.

        t1.start(); //t1 thread is in Runnable state
        System.out.println(Thread.currentThread().getState()+" "+t1.getState());

        t1.join(); //this makes the thread who is running this method(here,main thread) to wait until t1 thread has finished its execution(which makes the t1 thread to reach its terminated state).
        System.out.println(Thread.currentThread().getState()+" "+t1.getState()); //t1 thread is in terminated state
    }
}
