package Java_8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

//Predicate is a functional interface which is used to hold a condition by overriding its test().
//test() takes one argument & returns a boolean value by evaluating the input with the condition.

public class PredicateDemo
{
    public static void main(String[] args)
    {
        Predicate<Integer> isEven = x -> x%2==0;
        System.out.println(isEven.test(5)); //will return false

        //we can even combine different predicates
        Predicate<String> isWordStartingWithJ = x->x.toUpperCase().startsWith("J");
        Predicate<String> isWordEndingWithA = x->x.toUpperCase().endsWith("A");
        Predicate<String> combined = isWordStartingWithJ.and(isWordEndingWithA); //ANDing two predicates
        System.out.println(combined.test("Java")); // will return true

        //BiPredicate - A Predicate which accepts two arguments
        BiPredicate<Integer,Integer> isSumEven = (x,y) -> (x+y)%2==0;
        System.out.println(isSumEven.test(3,4));
    }
}
