package Java_8;

//Features of Java 8: Minimal code, Functional programming
//New concepts: lambda expression, Streams, Date & Time API

public class Java_8_Demo
{
    public static void main(String[] args)
    {
        //lambda expression:
        //An anonymous function(no name, no return type, no access modifiers)
        //Can only be used for functional interface(an interface with single abstract method while may or may not having static or default methods).
        //It is used to provide the implementation of the single abstract method of functional interface.
        Thread t = new Thread(()->{ //lambda expression to provide the implementation of run() of Runnable interface
            System.out.println("Hello");
        });
        //The reference variable of functional interface can be used to hold the lambda expression & invoke them later
        MathOperation sumOperation = (a,b)->a+b;
        System.out.println(sumOperation.operate(2,3));
    }
}

@FunctionalInterface //adding this annotation will let others know that it's a functional interface & also will throw compilation error if we try to add more abstract methods to it.
interface MathOperation {
    int operate(int a,int b);
}
