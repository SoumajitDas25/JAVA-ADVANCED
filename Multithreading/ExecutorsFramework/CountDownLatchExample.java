package Multithreading.ExecutorsFramework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample
{
    public static void main(String[] args) throws InterruptedException {
        int servicesCount =3; //no of tasks to be done

        ExecutorService executor = Executors.newFixedThreadPool(servicesCount);

        CountDownLatch latch = new CountDownLatch(servicesCount); //Creates a latch with a given Countdown, used for waiting the completion of multiple tasks(every time, a task completes, we will countdown the latch indicating the completion of one task).
        //CountDownLatch cant be reused once it reaches countdown to 0.

        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));

        latch.await(); //awaits until its countdown reaches 0 (we need to ensure that the given countdown reaches to 0 after the completion of all our tasks or else it will wait indefinitely).
        System.out.println("All Services finished");
        executor.shutdown();
    }
}

class DependentService implements Runnable
{
    private final CountDownLatch latch;
    DependentService(CountDownLatch latch)
    {
        this.latch=latch;
    }

    @Override
    public void run()
    {
        try{
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" Service Started");
        }
        catch (InterruptedException e)
        {

        }
        finally {
            latch.countDown();
        }
    }
}