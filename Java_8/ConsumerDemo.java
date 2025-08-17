package Java_8;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

//Consumer is a functional interface which is used to consume/accept some value & do some processing by overriding its accept().
//accept() takes an argument & does some processing on it but doesn't return anything.

public class ConsumerDemo
{
    public static void main(String[] args)
    {
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(5); // will print 5

        //BiConsumer - A Consumer which accepts two arguments
        BiConsumer<Integer,Integer> printSum = (x,y) -> System.out.println(x+y);
        printSum.accept(3,4);
    }
}
