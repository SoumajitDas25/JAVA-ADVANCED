package Java_8;

import java.util.function.BiFunction;
import java.util.function.Function;

//Function is a functional interface which is used to do some processing/work by overriding its apply().
//apply() takes an argument & does some processing on it & returns a value.

public class FunctionDemo
{
    public static void main(String[] args)
    {
        Function<Integer,Integer> doubleIt = x->x*2; //first type is argument type and second is return type.
        System.out.println(doubleIt.apply(10)); //will return 20
        Function<Integer,Integer> tripleIt = x->x*3;

        //here, we can combine in 2 different ways:
        //1. using andThen()
        System.out.println(doubleIt.andThen(tripleIt).apply(20)); //first doubleIt will be executed followed by tripleIt
        //2. using compose()
        System.out.println(doubleIt.compose(tripleIt).apply(20)); //first tripleIt will be executed followed by doubleIt

        //BiFunction - A Function which accepts two arguments
        BiFunction<Integer,Integer,Integer> getSum = (x,y) -> x+y;
        System.out.println(getSum.apply(5,6));
    }
}
