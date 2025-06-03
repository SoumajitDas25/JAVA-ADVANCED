package Multithreading;

public class ThreadUsingLambdaExpression
{
    public static void main(String[] args)
    {
        //Creating thread using lambda expression
        //lambda expression can only be used for functional interfaces(interfaces which have a single abstract method).
        Runnable task=()->System.out.println("Hii from "+Thread.currentThread().getName());
        Thread t1=new Thread(task,"Thread-1");

        Thread t2 =new Thread(()->
            System.out.println("Hello from "+Thread.currentThread().getName())
        ,"Thread-2");
        t1.start();
        t2.start();
    }
}