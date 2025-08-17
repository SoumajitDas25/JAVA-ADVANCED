package Java_8;

import java.util.function.Supplier;

//Supplier is a functional interface which is used to do some work & supply/return some value by implementation its get().
//get() doesn't takes any argument & does some work & returns some value.

public class SupplierDemo
{
    public static void main(String[] args)
    {
        Supplier<String> printHelloWorld = () -> "Hello World";
        System.out.println(printHelloWorld.get());
    }
}
