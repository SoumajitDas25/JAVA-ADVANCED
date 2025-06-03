package Multithreading;

class SharedResource
{
    private volatile boolean flag; //making it volatile means that the threads will read/write this variable from memory instead of their cache
    public void setFlagTrue()
    {
        this.flag=true;
    }
    public void printIfTrue()
    {
        while(!this.flag) //here, the reader thread will read from its own cache instead from the memory which is why the reader will read the old flag value stored in its cache which was false so it won't terminate from the loop even if the value gets true by another thread
        {
            //do nothing
        }
        System.out.println("Flag is true");
    }
}
public class VolatileExample
{
    public static void main(String[] args) throws InterruptedException {
        SharedResource ob = new SharedResource();
        Thread writer = new Thread(()->{
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            ob.setFlagTrue();
        });
        Thread reader = new Thread(()->{
            ob.printIfTrue();
        });
        writer.start();
        reader.start();
        writer.join();
        reader.join();
    }
}
